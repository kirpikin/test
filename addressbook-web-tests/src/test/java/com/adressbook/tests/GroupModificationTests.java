package com.adressbook.tests;

import com.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test(enabled = false)
    public void testGroupModification() {
        GroupData newGroup = new GroupData().withName("test2").withFooter("footer").withHeader("header");

        app.goTo().groupPage();
        if(!app.group().isThereAGroup()) {
            app.group().create(newGroup);
        }
        List<GroupData> before = app.group().list();
        app.group().selectGroup(before.size()-1);
        app.group().initGroupModification();
        app.group().fillGroupForm(newGroup);
        app.group().submitGroupModification();

        before.remove(before.size()-1);
        before.add(newGroup);
        app.group().returnToGroupPage();
        List<GroupData> after = app.group().list();

        Assert.assertEquals(before, after);
    };
}
