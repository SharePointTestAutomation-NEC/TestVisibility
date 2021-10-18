@testBidManager
Feature: Bid Manager as Create, update and delete.
  As a user who wants to create a new bid Manager
  I want to verify if the given fields are visible and enabled

  Background:
    Given I have logged into sharepoint

  @TC019_CreateBidManager
  Scenario Outline: Create a New Bid Manager
    Given I click on Create New bid Manager button
    And   Validate the required input Fields are visible and enabled in Create New Bid Manager page
    And   Create new bid Manager with values <BidName> and <AccountName>
    And   Verify the bid Manager successfully updated with titleName as <BidName>
    Examples:
      | BidName | AccountName |
      | SharePointTest | parmeshwar sakole |


  @TC020_EditBidManager
  Scenario Outline: Edit the Bid Manager
    Given  I click on Bid Manager as "SharePointTest"
    And    I click on Edit bar menu for editing the Bid Manager title Name
    And    Create new bid Manager with values <BidName> and <AccountName>
    And    Verify the bid Manager successfully updated with titleName as <BidName>
    Examples:
      | BidName        | AccountName |
      | ChnageBidemanager | parmeshwar sakole |

  @TC021_deleteBid
  Scenario: Delete the Bid Manager
    Given  I click on Bid Manager as "ChnageBidemanager"
    And    I click on Delete button for deleting the Bid Manager record
    And    I click on delete confirmation button for deleting
    Then   Verify the respective record got deleted

  @TC022_deleteBidNotavailble
  Scenario: Delete the Bid Manager
    Given  I click on Bid Manager as "ChnageBidemanager"
    And    I click on Delete button for deleting the Bid Manager record
    And    I click on delete confirmation button for deleting
    Then   Verify the respective record got deleted


