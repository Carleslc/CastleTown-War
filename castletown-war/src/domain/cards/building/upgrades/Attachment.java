package domain.cards.building.upgrades;

import domain.cards.Card;
import domain.cards.building.UpgradableBuilding;
import domain.exceptions.CannotActivateException;
import domain.exceptions.NotBuiltException;
import domain.player.Player;

public abstract class Attachment extends Card {
	
	private int attachCost;
	private UpgradableBuilding attachedBuilding;
	
	public Attachment(String name, int attachCost, int effectCost) {
		this(name, name, attachCost, effectCost);
	}
	
	public Attachment(String name, String description, int attachCost, int effectCost) {
		super(name, description, effectCost);
		this.attachCost = attachCost;
	}
	
	@Override
	public void activate(Player activator) throws CannotActivateException {
		if (!isAttached())
			throw new NotBuiltException(getName() + " is not attached to any building!");
		super.activate(activator);
	}
	
	public void attach(UpgradableBuilding building) throws CannotActivateException {
		building.setAttachment(this);
		attachedBuilding = building;
		attachEffect();
	}
	
	public abstract void attachEffect();
	
	public UpgradableBuilding getAttachedBuilding() {
		return attachedBuilding;
	}

	public boolean isAttached() {
		return attachedBuilding != null;
	}
	
	public int getAttachCost() {
		return attachCost;
	}

	public void setAttachCost(int attachCost) {
		this.attachCost = attachCost;
	}

}
