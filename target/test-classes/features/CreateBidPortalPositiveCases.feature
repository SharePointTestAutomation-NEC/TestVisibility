@testDemo
Feature: Verify inputs fields on Bid portal for positive scenarios.
  I want to verify if the given fields are visible and enabled

  Background:
    Given I have logged into sharepoint

  @TC023_ZipFiledownloads
    Scenario: Download the zip file from Bid creation
      Given I click on Bid List Menu Item
      And   I Navigate to exist Bid Created records
      And   I Navigate and switch the window to Bid List Record
      And   I click on the attachment for zip download purpose



  @TC024_CopyDocumentsd
  Scenario: Copy Documents from Exist Bid functionality
    Given I click on Bid List Menu Item
    And   I Navigate to exist Bid Created records
    And   I Navigate and switch the window to Bid List Record
    And   I click on the attachment and Copy Documents in another CRMID
    And   I select the dropDown as destination CRMID is "1989877020"
    And   I click on Copy and verify into respective CRMID

