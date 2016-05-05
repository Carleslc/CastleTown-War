package domain.cards.building;

import domain.cards.building.upgrades.Attachment;
import domain.exceptions.CannotActivateException;
import domain.exceptions.NotBuiltException;
import domain.exceptions.NotEnoughGoldException;
import domain.player.Player;

public abstract class UpgradableBuilding extends Building {

	protected Attachment attachment;
	
	public UpgradableBuilding(String name, int buildingCost, int effectCost) {
		super(name, buildingCost, effectCost);
	}
	
	public UpgradableBuilding(String name, int buildingCost, int effectCost, boolean built) {
		super(name, name, buildingCost, effectCost, built);
	}
	
	public UpgradableBuilding(String name, String description, int buildingCost, int effectCost, boolean built) {
		super(name, description, buildingCost, effectCost, built);
	}
	
	protected void applyEffect(Player activator) throws CannotActivateException {
		if (isUpgraded())
			attachment.activate(activator);
	}
	
	public boolean isUpgraded() {
		return attachment != null;
	}
	
	public Attachment getAttachment() {
		return attachment;
	}
	
	public void setAttachment(Attachment attachement) throws CannotActivateException {
		if (!isBuilt())
			throw new NotBuiltException(this);
		if (owner.getGold() < attachement.getAttachCost())
			throw new NotEnoughGoldException("Not enough gold to upgrade this building!");
		this.attachment = attachement;
		owner.substractGold(attachement.getAttachCost());
	}
}
