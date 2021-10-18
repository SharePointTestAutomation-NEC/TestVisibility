@test
Feature: Verify inputs fields on Bid Portal
  I want to verify if the given fields are visible and enabled

  Background:
    Given I have logged into sharepoint

    @TC025_ZipFileAlertBoxMsg
    Scenario: Download the zip file from Bid creation
      Given I click on Bid List Menu Item
      And   I Navigate to exist Bid Created records
      And   I Navigate and switch the window to Bid List Record
      And   I click on Zip button without selecting the attachment

  @TC026_FinalSubmissionAlertBoxMsg
  Scenario: Download the zip file from Bid creation
    Given I click on Bid List Menu Item
    And   I Navigate to exist Bid Created records
    And   I Navigate and switch the window to Bid List Record
    And   I click on final Submission button without selecting the attachment

  @TC027_CopyDocumentAlertBoxMsg
  Scenario: Download the zip file from Bid creation
    Given I click on Bid List Menu Item
    And   I Navigate to exist Bid Created records
    And   I Navigate and switch the window to Bid List Record
    And   I click on Copy Document button without selecting the attachment

  @TC028_duplicateCrmIDCheck
  Scenario Outline: : Create New bids
    Given I have logged in full permission user model
    And   I click on Bid List Menu Item
    And   I click on Create New bid button
    And   I Create new bids with values <BidTitle> and <ClientName> and <BidEventType> and <BidManager> and <SalesLead> and <Sensitivitylevel> and <Notes> and <Securityclearancerequirements> and <SubmissionInstructions>
    Then   Verify the error Message of CRMID
    Examples:
      | BidTitle       | ClientName       | BidEventType | BidManager | SalesLead | Sensitivitylevel  | Notes| Securityclearancerequirements  | SubmissionInstructions  | DocName                           |BidEventTypes|DocumentGrp   |subGrp|
      | UniqueNameTest | British Telecom1 | BAFO         | Test       | Matthew T | Standard Security | Notes1| SecurityClearanceRequirements1 | SubmissionInstructions1 | Bid Plan and Tracker - CRM 103501|BAFO|Bid Planning|Bid Plan|




