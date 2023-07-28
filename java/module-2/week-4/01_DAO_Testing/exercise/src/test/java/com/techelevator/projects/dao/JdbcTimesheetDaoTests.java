package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
    
    private JdbcTimesheetDao dao;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
    }

    @Test
    public void getTimesheetById_returns_correct_timesheet_for_id() {
        //Arrange

        //ACT
        Timesheet timesheet = dao.getTimesheetById(1);

        //Assert
        Assert.assertNotNull("Timesheet ID returned Null", timesheet);
        assertTimesheetsMatch(TIMESHEET_1, timesheet);

    }

    @Test
    public void getTimesheetById_returns_null_when_id_not_found() {
        //Arrange

        //ACT
        Timesheet timesheet = dao.getTimesheetById(5);
        //Assert
        Assert.assertNull("Timesheet ID is Null", timesheet);
    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {
        //Arrange

        //ACT
        List<Timesheet> timesheetList = dao.getTimesheetsByEmployeeId(1);

        //Assert
        Assert.assertNotNull("Timesheet List returned null", timesheetList);
        Assert.assertEquals("Expected size not returned", 2, timesheetList.size());

    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {

        //Arrange

        //ACT
        List<Timesheet> timesheetList = dao.getTimesheetsByProjectId(1);
        //Assert
        Assert.assertNotNull("Timesheet List returned null", timesheetList);
        Assert.assertEquals("Expected size not returned", 3, timesheetList.size());
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {

        //Arrange

        //ACT

        //Assert
        Assert.fail();
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {

        //Arrange

        //ACT

        //Assert
        Assert.fail();
    }

    @Test
    public void deleted_timesheet_can_no_longer_be_retrieved() {
        //Arrange

        //ACT

        //Assert

        Assert.fail();
    }

    @Test
    public void getBillableHours_returns_correct_total() {

        //Arrange

        //ACT

        //Assert

        Assert.fail();
    }

    private void assertTimesheetsMatch(Timesheet expected, Timesheet actual) {
        Assert.assertEquals(expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(expected.isBillable(), actual.isBillable());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
    }

}
