Feature: Website
  Background:

    @Testcase01
    Scenario: Verify login successfully
      When Go to website
      And Enter username and password
      And Click login button
      Then Verify dashboard

    @Testcase02
    Scenario: Verify placeholder and checkbox
      When Go to website
      Then Verify placeholder
      Then Verify Remember checkbox is selected
