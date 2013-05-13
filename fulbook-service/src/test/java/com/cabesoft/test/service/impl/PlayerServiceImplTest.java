package com.cabesoft.test.service.impl;

import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import com.cabesoft.domain.dao.impl.PlayerDaoImpl;
import com.cabesoft.domain.enums.PhysicalSlot;
import com.cabesoft.domain.enums.PhysicalStat;
import com.cabesoft.domain.enums.SocialSlot;
import com.cabesoft.domain.enums.SocialStat;
import com.cabesoft.domain.model.Player;
import com.cabesoft.model.dto.PhysicalItemDTO;
import com.cabesoft.model.dto.PlayerDTO;
import com.cabesoft.model.dto.SocialItemDTO;
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
	public void failToEquipPhysicalItemNotEnoughLevel() {
		PhysicalItemDTO physicalItemDTO = this.createPhysicalItemDTO();
		physicalItemDTO.setRequiredLevel(10);
		this.messiDTO.getPhysicalItems().add(physicalItemDTO);
		Assert.isTrue(!this.playerServiceImpl.equipPhysicalItem(messiDTO,
				physicalItemDTO));

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
	public void failToEquipSocialItemNotEnoughLevel() {
		SocialItemDTO socialItemDTO = this.createSocialItemDTO();
		socialItemDTO.setRequiredLevel(10);
		this.messiDTO.getSocialItems().add(socialItemDTO);
		Assert.isTrue(!this.playerServiceImpl.equipSocialItem(messiDTO,
				socialItemDTO));

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

	@Test
	public void roomOnInventorySucces() {
		SocialItemDTO socialItemDTO2 = this.createSocialItemDTO2();
		this.messiDTO.getSocialItems().add(socialItemDTO2);
		boolean succes = this.playerServiceImpl.roomOnInventory(messiDTO);
		Assert.isTrue(succes);
	}

	@Test
	public void roomOnInventoryNotSucces() {
		SocialItemDTO socialItemDTO2 = this.createSocialItemDTO2();
		this.messiDTO.getSocialItems().add(socialItemDTO2);
		this.messiDTO.getSocialItems().add(socialItemDTO2);
		this.messiDTO.getSocialItems().add(socialItemDTO2);
		this.messiDTO.getSocialItems().add(socialItemDTO2);
		this.messiDTO.getSocialItems().add(socialItemDTO2);

		boolean succes = this.playerServiceImpl.roomOnInventory(messiDTO);
		Assert.isTrue(!succes);
	}

	@Test
	public void addPointsToSocialFailure() {

		boolean succes = this.playerServiceImpl.addPointToSocialStat(messiDTO,
				SocialStat.HAPPINESS, 10);
		Assert.isTrue(!succes);
	}

	@Test
	public void addPointsToSocial() {
		messiDTO.setSocialPointsToAsign(4);
		boolean succes = this.playerServiceImpl.addPointToSocialStat(messiDTO,
				SocialStat.HAPPINESS, 3);
		Assert.isTrue(succes);
		Assert.isTrue(messiDTO.getSocialPointsToAsign() == 1);
	}

	@Test
	public void addPointsToPhysicalFailure() {

		boolean succes = this.playerServiceImpl.addPointToPhysicalStat(
				messiDTO, PhysicalStat.STRENGTH, 10);
		Assert.isTrue(!succes);
	}

	@Test
	public void addPointsToPhysical() {
		messiDTO.setPhysicalPointsToAsign(4);
		boolean succes = this.playerServiceImpl.addPointToPhysicalStat(
				messiDTO, PhysicalStat.STRENGTH, 3);
		Assert.isTrue(succes);
		Assert.isTrue(messiDTO.getPhysicalPointsToAsign() == 1);
	}

	private Player createMessi() {

		Map<PhysicalStat, Integer> physicalItemStats = new HashMap<PhysicalStat, Integer>();
		physicalItemStats.put(PhysicalStat.STRENGTH, 10);

		// same for social

		Map<SocialStat, Integer> socialItemStats = new HashMap<SocialStat, Integer>();
		socialItemStats.put(SocialStat.HAPPINESS, 100);

		return new Player("messi", "1", socialItemStats, physicalItemStats);
	}

	private PhysicalItemDTO createPhysicalItemDTO() {
		PhysicalItemDTO physicalItemDTO = new PhysicalItemDTO();
		physicalItemDTO.setId(1);
		physicalItemDTO
				.setDescription("es el item mas pedorro del juego, no se ni por que lo hice");
		physicalItemDTO.setName("Casco de futbol americano");
		physicalItemDTO.setSlot(PhysicalSlot.HEAD);
		physicalItemDTO.getStats().put(PhysicalStat.STRENGTH, 40);
		physicalItemDTO.setRequiredLevel(1);
		return physicalItemDTO;
	}

	private PhysicalItemDTO createPhysicalItemDTO2() {
		PhysicalItemDTO physicalItemDTO = new PhysicalItemDTO();
		physicalItemDTO.setId(2);
		physicalItemDTO.setDescription("segundo item");
		physicalItemDTO.setName("vicera re piola");
		physicalItemDTO.setSlot(PhysicalSlot.HEAD);
		physicalItemDTO.getStats().put(PhysicalStat.DRIBLING, 10);
		physicalItemDTO.setRequiredLevel(1);
		return physicalItemDTO;
	}

	private SocialItemDTO createSocialItemDTO() {
		SocialItemDTO socialItemDTO = new SocialItemDTO();
		socialItemDTO.setId(2);
		socialItemDTO.setDescription("hija del verdu");
		socialItemDTO.setName("La Yemi");
		socialItemDTO.setSlot(SocialSlot.GIRLFRIEND);
		socialItemDTO.getStats().put(SocialStat.HAPPINESS, -3);
		socialItemDTO.setRequiredLevel(1);
		return socialItemDTO;
	}

	private SocialItemDTO createSocialItemDTO2() {
		SocialItemDTO socialItemDTO = new SocialItemDTO();
		socialItemDTO.setId(2);
		socialItemDTO
				.setDescription("esta mas buena que comer pollo con la mano");
		socialItemDTO.setName("Pamela anderson");
		socialItemDTO.setSlot(SocialSlot.GIRLFRIEND);
		socialItemDTO.getStats().put(SocialStat.HAPPINESS, 50);
		socialItemDTO.setRequiredLevel(1);

		return socialItemDTO;
	}
}
