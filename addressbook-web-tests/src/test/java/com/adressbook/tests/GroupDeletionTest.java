package com.adressbook.tests;

import com.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if(!app.group().isThereAGroup()) {
            app.group().create(new GroupData().withName("test1").withFooter("erre").withHeader("wrewrw"));
        }
    }

    @Test
    public void testGroupDelete() {

        List<GroupData> before = app.group().list();
        app.groupHelper.selectGroup(before.size()-1);
        app.groupHelper.deleteSelectedGroup();
        app.groupHelper.returnToGroupPage();
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size()-1);

        before.remove(before.size()-1);
        Assert.assertEquals(before, after);
    }
}
