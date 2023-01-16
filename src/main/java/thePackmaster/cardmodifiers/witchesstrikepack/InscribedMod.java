package thePackmaster.cardmodifiers.witchesstrikepack;

import basemod.abstracts.AbstractCardModifier;
import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.CardHelper;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.orbs.PackmasterOrb;

public class InscribedMod extends AbstractCardModifier {
    private CardStrings uiStrings =  CardCrawlGame.languagePack.getCardStrings(SpireAnniversary5Mod.makeID("Inscribed"));
    private boolean inherent = false;
    private boolean Todesc = true;
    public InscribedMod(boolean inherent,boolean todesc) {
        Todesc = todesc;
    }
    public void onUpdate(AbstractCard card) {
        if (CardCrawlGame.dungeon != null){
            if (card.canUse(AbstractDungeon.player, null)) {
                card.glowColor = CardHelper.getColor(75, 44, 112);
            }
        }
    }
    public boolean isInherent(AbstractCard card) {
        return inherent;
    }
    @Override
    public String modifyDescription(String rawDescription, AbstractCard card) {
        if (Todesc) {
            return uiStrings.EXTENDED_DESCRIPTION[0] + rawDescription;
        } else return rawDescription;
    }

    @Override
    public String identifier(AbstractCard card) {
        return "Inscribed";
    }
    public boolean shouldApply(AbstractCard card) {
        return !CardModifierManager.hasModifier(card, "Inscribed");
    }
    @Override
    public AbstractCardModifier makeCopy() {
        return new InscribedMod(inherent,Todesc);
    }
}