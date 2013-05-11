package com.cabesoft.test.service.impl;

import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import com.cabesoft.domain.dao.impl.PlayerDaoImpl;
import com.cabesoft.domain.enums.PhysicalSlot;
import com.cabesoft.domain.enums.SocialSlot;
import com.cabesoft.domain.model.PhysicalStat;
import com.cabesoft.domain.model.PhysicalStatAmount;
import com.cabesoft.domain.model.Player;
import com.cabesoft.domain.model.SocialStat;
import com.cabesoft.domain.model.SocialStatAmount;
import com.cabesoft.model.dto.PhysicalItemDTO;
import com.cabesoft.model.dto.PhysicalStatAmountDTO;
import com.cabesoft.model.dto.PhysicalStatDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.model.dto.SocialItemDTO;
import com.cabesoft.model.dto.SocialStatAmountDTO;
import com.cabesoft.model.dto.SocialStatDTO;
import com.cabesoft.service.impl.PlayerServiceImpl;

public class PlayerServiceImplTest {

	@Mock
	public PlayerDaoImpl playerDaoImpl;

	public Player messi;

	public PlayerDTO messiDTO;
	Mapper mapper = new DozerBeanMapper();

	public PlayerServiceImpl playerServiceImpl = new PlayerServiceImpl();

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.messi = this.createMessi();
		when(this.playerDaoImpl.getPlayerByName("messi"))
				.thenReturn(this.messi);
		this.playerServiceImpl.setMapper(mapper);
		this.playerServiceImpl.setPlayerDao(this.playerDaoImpl);
		this.messiDTO = mapper.map(this.messi, PlayerDTO.class);
	}

	@Test
	public void checkNameOfExistingPlayer() {
		boolean exists = this.playerServiceImpl.checkNameAvailable("messi");
		Assert.isTrue(exists);
	}

	@Test
	public void addExpirienceWithNoModifyOnLevel() {
		this.playerServiceImpl.addExpirience(this.messiDTO, 1);
		Assert.isTrue(messiDTO.getExpirience() == 1 && messiDTO.getLevel() == 1);
	}

	@Test
	public void addExpirienceModifyOneLevelCheckLevelAndStats() {
		this.playerServiceImpl.addExpirience(this.messiDTO, 20);
		Assert.isTrue(messiDTO.getExpirience() == 20
				&& messiDTO.getLevel() == 2);
		Assert.isTrue(messiDTO.getPhysicalPointsToAsign() == 5);
		Assert.isTrue(messiDTO.getSocialPointsToAsign() == 3);
	}

	@Test
	public void addExpirienceModifyMoreThanOneLevelCheckLevelAndStats() {
		this.playerServiceImpl.addExpirience(this.messiDTO, 30);
		Assert.isTrue(messiDTO.getExpirience() == 30
				&& messiDTO.getLevel() == 3);
		Assert.isTrue(messiDTO.getPhysicalPointsToAsign() == 10);
		Assert.isTrue(messiDTO.getSocialPointsToAsign() == 6);
	}

	@Test
	public void checkNameOfNonExistingPlayer() {
		boolean exists = this.playerServiceImpl.checkNameAvailable("beto");
		Assert.isTrue(!exists);
	}

	@Test
	public void equipPhysicalItemWithNoOtherInThatPosition() {
		PhysicalItemDTO physicalItemDTO = this.createPhysicalItemDTO();
		this.messiDTO.getPhysicalItems().add(physicalItemDTO);
		this.playerServiceImpl.equipPhysicalItem(messiDTO, physicalItemDTO);
		Assert.isTrue(this.messiDTO.getBodyParts().get(PhysicalSlot.HEAD) != null);
		Assert.isTrue(messiDTO.getPhysicalItems().size() == 0);

	}

	@Test
	public void equipPhysicalItemWithAnotherInThatPosition() {
		PhysicalItemDTO physicalItemDTO1 = this.createPhysicalItemDTO();
		PhysicalItemDTO physicalItemDTO2 = this.createPhysicalItemDTO2();
		this.messiDTO.getPhysicalItems().add(physicalItemDTO2);
		messiDTO.getBodyParts().put(PhysicalSlot.HEAD, physicalItemDTO1);
		this.playerServiceImpl.equipPhysicalItem(messiDTO, physicalItemDTO2);
		Assert.isTrue(this.messiDTO.getBodyParts().get(PhysicalSlot.HEAD)
				.equals(physicalItemDTO2));
		Assert.isTrue(messiDTO.getPhysicalItems().iterator().next()
				.equals(physicalItemDTO1));
	}

	@Test
	public void equipPSocialItemThatIsNotInTheInventory() {
		SocialItemDTO socialItemDTO2 = this.createSocialItemDTO2();
		boolean succes = this.playerServiceImpl.equipSocialItem(messiDTO,
				socialItemDTO2);
		Assert.isTrue(!succes);
	}

	@Test
	public void equipSocialItemWithNoOtherInThatPosition() {
		SocialItemDTO socialItemDTO = this.createSocialItemDTO();
		this.messiDTO.getSocialItems().add(socialItemDTO);
		this.playerServiceImpl.equipSocialItem(messiDTO, socialItemDTO);
		Assert.isTrue(this.messiDTO.getSocialParts().get(SocialSlot.GIRLFRIEND) != null);
		Assert.isTrue(messiDTO.getSocialItems().size() == 0);

	}

	@Test
	public void equipSocialItemWithAnotherInThatPosition() {
		SocialItemDTO socialItemDTO1 = this.createSocialItemDTO();
		SocialItemDTO socialItemDTO2 = this.createSocialItemDTO2();
		this.messiDTO.getSocialItems().add(socialItemDTO2);
		messiDTO.getSocialParts().put(SocialSlot.GIRLFRIEND, socialItemDTO1);
		this.playerServiceImpl.equipSocialItem(messiDTO, socialItemDTO2);
		Assert.isTrue(this.messiDTO.getSocialParts().get(SocialSlot.GIRLFRIEND)
				.equals(socialItemDTO2));
		Assert.isTrue(messiDTO.getSocialItems().iterator().next()
				.equals(socialItemDTO1));
	}

	@Test
	public void equipPhysicalItemThatIsNotInTheInventory() {
		PhysicalItemDTO physicalItemDTO2 = this.createPhysicalItemDTO2();
		boolean succes = this.playerServiceImpl.equipPhysicalItem(messiDTO,
				physicalItemDTO2);
		Assert.isTrue(!succes);
	}

	@Test
	public void unequipPhysicalItemThatIsEquiped() {
		PhysicalItemDTO physicalItemDTO2 = this.createPhysicalItemDTO2();
		this.messiDTO.getBodyParts().put(PhysicalSlot.HEAD, physicalItemDTO2);
		boolean succes = this.playerServiceImpl.unEquipPhysicalItem(messiDTO,
				physicalItemDTO2);
		Assert.isTrue(succes);
	}

	@Test
	public void unequipPhysicalItemThatIsNotEquiped() {
		PhysicalItemDTO physicalItemDTO2 = this.createPhysicalItemDTO2();
		boolean succes = this.playerServiceImpl.unEquipPhysicalItem(messiDTO,
				physicalItemDTO2);
		Assert.isTrue(!succes);
	}

	@Test
	public void unequipSocialItemThatIsEquiped() {
		SocialItemDTO socialItemDTO2 = this.createSocialItemDTO2();
		this.messiDTO.getSocialParts().put(SocialSlot.GIRLFRIEND,
				socialItemDTO2);
		boolean succes = this.playerServiceImpl.unEquipSocialItem(messiDTO,
				socialItemDTO2);
		Assert.isTrue(succes);
	}

	@Test
	public void unequipSocialItemThatIsNotEquiped() {
		SocialItemDTO socialItemDTO2 = this.createSocialItemDTO2();
		boolean succes = this.playerServiceImpl.unEquipSocialItem(messiDTO,
				socialItemDTO2);
		Assert.isTrue(!succes);
	}

	private Player createMessi() {
		PhysicalStat physicalStat = new PhysicalStat();
		physicalStat.setName("destreza");
		PhysicalStatAmount physicalStatAmount = new PhysicalStatAmount(
				physicalStat, 20);
		Set<PhysicalStatAmount> physicalItemStats = new HashSet<PhysicalStatAmount>();
		physicalItemStats.add(physicalStatAmount);

		// same for social

		SocialStat socialStat = new SocialStat();
		socialStat.setName("felicidad");

		SocialStatAmount socialStatAmount = new SocialStatAmount(socialStat, 5);
		Set<SocialStatAmount> socialItemStats = new HashSet<SocialStatAmount>();
		socialItemStats.add(socialStatAmount);

		return new Player("messi", "1", socialItemStats, physicalItemStats);
	}

	private PhysicalItemDTO createPhysicalItemDTO() {
		PhysicalItemDTO physicalItemDTO = new PhysicalItemDTO();
		physicalItemDTO.setId(1);
		physicalItemDTO
				.setDescription("es el item mas pedorro del juego, no se ni por que lo hice");
		physicalItemDTO.setName("Casco de futbol americano");
		physicalItemDTO.setSlot(PhysicalSlot.HEAD);
		PhysicalStatDTO physicalStatDTO = new PhysicalStatDTO();
		physicalStatDTO.setId(1);
		physicalStatDTO.setName("Fuerza");

		PhysicalStatAmountDTO physicalStatAmountDTO = new PhysicalStatAmountDTO(
				physicalStatDTO, 10);
		Set<PhysicalStatAmountDTO> itemStats = new HashSet<PhysicalStatAmountDTO>();
		itemStats.add(physicalStatAmountDTO);
		physicalItemDTO.setStats(itemStats);

		return physicalItemDTO;
	}

	private PhysicalItemDTO createPhysicalItemDTO2() {
		PhysicalItemDTO physicalItemDTO = new PhysicalItemDTO();
		physicalItemDTO.setId(2);
		physicalItemDTO.setDescription("segundo item");
		physicalItemDTO.setName("vicera re piola");
		physicalItemDTO.setSlot(PhysicalSlot.HEAD);
		PhysicalStatDTO physicalStatDTO = new PhysicalStatDTO();
		physicalStatDTO.setId(2);
		physicalStatDTO.setName("Destreza");

		PhysicalStatAmountDTO physicalStatAmountDTO = new PhysicalStatAmountDTO(
				physicalStatDTO, 3);
		Set<PhysicalStatAmountDTO> itemStats = new HashSet<PhysicalStatAmountDTO>();
		itemStats.add(physicalStatAmountDTO);
		physicalItemDTO.setStats(itemStats);

		return physicalItemDTO;
	}

	private SocialItemDTO createSocialItemDTO() {
		SocialItemDTO socialItemDTO = new SocialItemDTO();
		socialItemDTO.setId(2);
		socialItemDTO.setDescription("hija del verdu");
		socialItemDTO.setName("La Yemi");
		socialItemDTO.setSlot(SocialSlot.GIRLFRIEND);
		SocialStatDTO socialStatDTO = new SocialStatDTO();
		socialStatDTO.setId(2);
		socialStatDTO.setName("felicidad");

		SocialStatAmountDTO socialStatAmountDTO = new SocialStatAmountDTO(
				socialStatDTO, 3);
		Set<SocialStatAmountDTO> itemStats = new HashSet<SocialStatAmountDTO>();
		itemStats.add(socialStatAmountDTO);
		socialItemDTO.setStats(itemStats);

		return socialItemDTO;
	}

	private SocialItemDTO createSocialItemDTO2() {
		SocialItemDTO socialItemDTO = new SocialItemDTO();
		socialItemDTO.setId(2);
		socialItemDTO.setDescription("hija del carnicero");
		socialItemDTO.setName("La Yoli");
		socialItemDTO.setSlot(SocialSlot.GIRLFRIEND);
		SocialStatDTO socialStatDTO = new SocialStatDTO();
		socialStatDTO.setId(2);
		socialStatDTO.setName("felicidad");

		SocialStatAmountDTO socialStatAmountDTO = new SocialStatAmountDTO(
				socialStatDTO, 7);
		Set<SocialStatAmountDTO> itemStats = new HashSet<SocialStatAmountDTO>();
		itemStats.add(socialStatAmountDTO);
		socialItemDTO.setStats(itemStats);

		return socialItemDTO;
	}
}
