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
import com.cabesoft.domain.model.PhysicalStat;
import com.cabesoft.domain.model.PhysicalStatAmount;
import com.cabesoft.domain.model.Player;
import com.cabesoft.domain.model.SocialStat;
import com.cabesoft.domain.model.SocialStatAmount;
import com.cabesoft.model.dto.PhysicalItemDTO;
import com.cabesoft.model.dto.PhysicalStatAmountDTO;
import com.cabesoft.model.dto.PhysicalStatDTO;
import com.cabesoft.model.dto.PlayerDTO;
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
	public void addExpirienceModifyOneLevel() {
		this.playerServiceImpl.addExpirience(this.messiDTO, 52);
		Assert.isTrue(messiDTO.getExpirience() == 52
				&& messiDTO.getLevel() == 2);
	}

	@Test
	public void addExpirienceModifyMoreThanOneLevel() {
		this.playerServiceImpl.addExpirience(this.messiDTO, 101);
		Assert.isTrue(messiDTO.getExpirience() == 101
				&& messiDTO.getLevel() == 3);
	}

	@Test
	public void checkNameOfNonExistingPlayer() {
		boolean exists = this.playerServiceImpl.checkNameAvailable("beto");
		Assert.isTrue(!exists);
	}

	@Test
	public void equipPhysicalItemWithNoOtherInThatPosition() {
		PhysicalItemDTO physicalItemDTO = new PhysicalItemDTO();
		Set<PhysicalStatAmountDTO> physicalStatAmountDTOs = new HashSet<PhysicalStatAmountDTO>();
		PhysicalStatDTO physicalStatDTO = new PhysicalStatDTO();
		physicalStatDTO.setId(1);

	}

	@Test
	public void equipPhysicalItemWithAnotherInThatPosition() {
		boolean exists = this.playerServiceImpl.checkNameAvailable("beto");
		Assert.isTrue(!exists);
	}

	@Test
	public void equipPhysicalItemThatIsNotInTheInventory() {
		boolean exists = this.playerServiceImpl.checkNameAvailable("beto");
		Assert.isTrue(!exists);
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
}
