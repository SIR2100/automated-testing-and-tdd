package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

public class ClientTest {
    @Test
    public void shouldSavePropertiesWhenCreated() {
        //region given
        UUID stubId = UUID.randomUUID();
        //endregion

        //region when
        Client sut = new Client(stubId, "dummy client name");
        //endregion

        //region then
        assertThat(sut.getId(),
                allOf(
                        equalTo(stubId),
                        notNullValue()
                ));
        //endregion
    }

    @Test
    public void shouldElementContainedWhenAdded() {
        //region given
        UUID stubId = UUID.randomUUID();
        //endregion

        //region when
        Client client = new Client(stubId, "dummy client name");
        SavingAccount account = new SavingAccount(stubId, client, 0);
        client.addAccount(account);
        //endregion

        //region then
        assertTrue(client.getAccounts().contains(account));
        //endregion
    }

    @Test
    public void shouldNameIsEqualWhenAdded() {
        //region given
        UUID stubId = UUID.randomUUID();
        //endregion

        //region when
        String name = "dummy client name";
        Client client = new Client(stubId, "dummy client name");
        SavingAccount account = new SavingAccount(stubId, client, 0);
        client.addAccount(account);
        //endregion

        //region then
        assertTrue(client.getName() == name);
        //endregion
    }

    @Test
    public void shouldElementNotExistWhenRemoved() {
        //region given
        UUID stubId = UUID.randomUUID();
        //endregion

        //region when
        Client client = new Client(stubId, "dummy client name");
        SavingAccount account = new SavingAccount(stubId, client, 0);
        client.addAccount(account);
        assumeTrue(client.getAccounts().contains(account));
        client.removeAccount(account);
        //endregion

        //region then
        assertFalse(client.getAccounts().contains(account));
        //endregion
    }
}
