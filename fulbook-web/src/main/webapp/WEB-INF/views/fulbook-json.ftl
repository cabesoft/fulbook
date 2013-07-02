<#ftl encoding="UTF-8" />
<#import "/spring.ftl" as s />

<#if errors??>
	{ "errors" : [ 
	<#assign x = 1>
	<#list errors?keys as error >
		<#assign mess> 
			<@s.message "${errors[error]}" />
		</#assign>
		<#if errors?size == x>
			{ "error" : "${mess}" }
		<#else>
			{ "error" : "${mess}" },
		</#if>
		<#assign x = x + 1>
	</#list>
	] }
<#else>
	{ "data" : "OK" }
</#if>
