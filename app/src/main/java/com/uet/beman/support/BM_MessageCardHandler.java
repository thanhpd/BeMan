package com.uet.beman.support;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.uet.beman.object.MessageCard;

import java.util.HashMap;

import it.gmariotti.cardslib.library.view.CardView;

/**
 * Created by PhanDuy on 4/20/2015.
 */
public class BM_MessageCardHandler {
    public static BM_MessageCardHandler instance = null;
    private HashMap<String, MessageCard> msgCardSet;
    private HashMap<String, CardView> cardViewSet;
    private BM_StorageHandler storageHandler;

    private BM_MessageCardHandler() {
        msgCardSet = new HashMap<>();
        cardViewSet = new HashMap<>();
        storageHandler = BM_StorageHandler.getInstance();
    }

    public static BM_MessageCardHandler getInstance() {
        if(instance == null) instance = new BM_MessageCardHandler();
        return instance;
    }

    public void setCardInCardSet(Context context, String label, Fragment fragment) {
        MessageCard card = new MessageCard(context, label);
        card.init();
        card.setFragment(fragment);
        card.updateMessageItems(label);
        msgCardSet.put(label, card);
    }

    public MessageCard getCardInCardSet(String label) {
        return msgCardSet.get(label);
    }

    public void setCardView(View view, int id, String label, Context context, Fragment fragment) {
        CardView cardView = (CardView) view.findViewById(id);
        setCardInCardSet(context, label, fragment);
        MessageCard card = getCardInCardSet(label);
        cardView.setCard(card);
    }
}
