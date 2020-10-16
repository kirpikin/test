package com.adressbook.tests;

import com.adressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.navigationHelper.groupPage();
        List<GroupData> before = app.group().list();
        app.group().create(new GroupData().withName("New form"));
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size()+1);
        //driver.findElement(By.cssSelector("html")).click();
    }

}