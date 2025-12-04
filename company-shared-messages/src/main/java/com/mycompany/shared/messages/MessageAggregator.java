package com.mycompany.shared.messages;

import com.mycompany.shared.model.account.AccountDto;
import com.mycompany.shared.model.transfers.TransferDto;

public final class MessageAggregator {

    private MessageAggregator() {}

    public static String summarize(AccountDto account, TransferDto transfer) {
        return String.format("Account[%s:%s] Transfer[%s:%s]",
            account == null ? "null" : account.getAccountId(),
            account == null ? "null" : account.getOwner(),
            transfer == null ? "null" : transfer.getTransferId(),
            transfer == null ? "null" : transfer.getAmount()
        );
    }
}
