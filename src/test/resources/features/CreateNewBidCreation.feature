@BidPortalTest01
Feature: BidCreation as Create, update and delete.
  As a user who wants to create a new bid Creation
  I want to verify if the given fields are visible and enabled

  Background:
    #Given I have logged into sharepoint

  @TC001_Bid_Creation  #done
  Scenario Outline: : Create a New bid
    Given I have logged in full permission user model AdminRights
    And   I click on Bid List Menu Item
    And   I click on Create New bid button
    And   I Create new bids with values <BidTitle> and <ClientName> and <BidEventType> and <BidManager> and <SalesLead> and <Sensitivitylevel> and <Notes> and <Securityclearancerequirements> and <SubmissionInstructions>
    Then  I Verify the bid Creation successfully created with values of <BidTitle> and <ClientName> and <BidEventType> and <BidManager> and <SalesLead> and <Sensitivitylevel> and <Notes> and <Securityclearancerequirements> and <SubmissionInstructions>
    And   I Navigate to Upload the buttons
    And   I Navigate to verify document and selection drop value as <DocName> and <DocTypes> and <DocumentGrp> and <subGrp>

    Examples:
      | BidTitle       | ClientName       | BidEventType | BidManager | SalesLead | Sensitivitylevel  | Notes| Securityclearancerequirements  | SubmissionInstructions  | DocName                           |DocTypes|DocumentGrp   |subGrp|
      | Bid Creation Test on environment | British Telecom1 | BAFO         | Test       | Matthew T | Standard Security | Notes1| SecurityClearanceRequirements1 | SubmissionInstructions1 | Bid Plan and Tracker - CRM 103501|BAFO|Bid Planning|Bid Plan|

  @TC002_ZipFileDownLoad   #done
  Scenario Outline: Download the zip file from Bid creation
    Given   I have logged in full permission user model AdminRights
      And   I click on Bid List Menu Item
      And   I Navigate to exist Bid Created records
      And   I Navigate and switch the window to Bid List Record
      And   I click on Zip button without selecting the attachment
      And   I Navigate to Upload the buttons
      And   I Navigate to verify document and selection drop value as <DocName> and <BidEventType> and <DocumentGrp> and <subGrp>
      And   Select the respective doc for ZipDownload and doc name is as <DocName>
      Then  I click on the zip button for and verify zip gets downloaded
      Examples:
        | DocName                           |BidEventType|DocumentGrp|subGrp|
        | Bid Plan and Tracker - CRM 103501|BAFO|Bid Planning|Bid Plan|

  @TC003_ViewBidCreationVerification #done
  Scenario: View All Properties from exist Bid List
    Given I have logged in full permission user model AdminRights
    And   I click on Bid List Menu Item
    And   I Navigate to exist Bid Created records
    And   I Navigate and switch the window to Bid List Record
    And   I Navigate to View all properties link

  @TC004_Update_BidUserName #fail
  Scenario:  Edit Properties from exist Bid List
    Given I have logged in full permission user model AdminRights
    And   I click on Bid List Menu Item
    And   I Navigate to click on earlier created Bid record
    And   I Navigate and switch the window to Bid List Record
    And   I Navigate to Edit properties link ChangeBidNameTO
    Then  Verify the updated data ChangeBidNameTO

  @TC005_CopyDocumentFromExistBid #done
  Scenario Outline: Copy Documents from Exist Bid functionality
    Given I have logged in full permission user model AdminRights
    And  I click on Bid List Menu Item
    And   I Navigate to click on earlier created Bid record
    And   I Navigate and switch the window to Bid List Record
    And   I click on the attachment and Copy Documents in another CRMID
    #CRMID update into config file
    And   I select the dropDown as destination CRMID
    And   I click on Copy and verify into respective CRMID
    And   I Navigate and switch the window to Bid List Record
    And   Select the respective doc for ZipDownload and doc name is as <DocName>
    Examples:
      | DocName                           |
      | Bid Plan and Tracker - CRM 103501 |

  @TC006_CheckInAndCheckOutFlow #done
  Scenario Outline: Check in and check out validation
    Given I have logged in full permission user model AdminRights
    And I click on Bid List Menu Item
    And   I Navigate to click on earlier created Bid record
    And   I Navigate and switch the window to Bid List Record
    And   I Navigate to Upload the buttons
    And   I Navigate to verify document and selection drop value as <DocName> and <BidEventType> and <DocumentGrp> and <subGrp>
    And   I click on More menu and check the verify checkout popupWindow
    And   I click on advance option
    And   I click on CheckInAndOut option from Advance Menu
    And   Select the respective doc for ZipDownload and doc name is as <DocName>
    And   I click on More menu and check the verify checkout popupWindow
    And   I click on advance option
    And   I click on CheckInAndOut option from Advance Menu
    Then  Verify the check out popup window display or not
    Examples:
      | DocName                           | BidEventType | DocumentGrp  | subGrp   |
      | Bid Plan and Tracker - CRM 103501 | BAFO         | Bid Planning | Bid Plan |


  @TC007_DeleteAttachment #done
  Scenario Outline: Delete the Attachment
    Given I have logged in full permission user model AdminRights
    And   I click on Bid List Menu Item
    And   I Navigate to click on earlier created Bid record
    And   I Navigate and switch the window to Bid List Record
    And   I Navigate to Upload the buttons
    And   I Navigate to verify document and selection drop value as <DocName> and <BidEventType> and <DocumentGrp> and <subGrp>
    And   I click on More menu and check the verify checkout popupWindow
    And   I click on Delete option
    And   Verify the alert popup window display or not
    And   Select the respective doc not present after get deleted <DocName>
    Examples:
      | DocName                           | BidEventType | DocumentGrp  | subGrp   |
      | Bid Plan and Tracker - CRM 103501 | BAFO         | Bid Planning | Bid Plan |


  @TC008_RestrictedBidCreation  #done
  Scenario Outline: : Create Restricted New bids
    Given I have logged in full permission user model AdminRights
    And   I click on Bid List Menu Item
    And   I click on Create New bid button
    And   I Create new bids with values <BidTitle> and <ClientName> and <BidEventType> and <BidManager> and <SalesLead> and <Sensitivitylevel> and <Notes> and <Securityclearancerequirements> and <SubmissionInstructions>
    And   I Verify the restricted bid Creation successfully created with values of <BidTitle> and <ClientName> and <BidEventType> and <BidManager> and <SalesLead> and <Sensitivitylevel> and <Notes> and <Securityclearancerequirements> and <SubmissionInstructions>
    And   I click on Home Page Menu left hand side bar
    And   I click on Restricted widget from DashBoard
    Then   I click on Restricted Bid Created
    Examples:
      | BidTitle       | ClientName       | BidEventType | BidManager | SalesLead | Sensitivitylevel  | Notes| Securityclearancerequirements  | SubmissionInstructions  |
      | Restricted Bid creation Test by parmeshwar | British Telecom1 | BAFO         | Test       | Matthew T | Restricted Access | Notes1| SecurityClearanceRequirements1 | SubmissionInstructions1 |


  @TC008_RestrictedBidDeletion #done
  Scenario: Create Restricted delete
    Given I have logged in full permission user model AdminRights
    And   I click on Bid List Menu Item
    And   I click on Home Page Menu left hand side bar
    And   I click on Restricted widget from DashBoard
    And   I click on Restricted Bid Created
    And   I click on Delete button for deleting the Bid Manager record
    And   I click on delete confirmation button for deleting
    Then  Verify the respective record got deleted

   # Search functionality in Bid
  @TC009_SearchContentInsideBidRecord #done
  Scenario: Verify the search functionality as Content base search
    Given I have logged in full permission user model AdminRights
    And   I click on Bid List Menu Item
    #BidNumberForSearch needs to udate in config property file.
    And   I Navigate to click on Bid record who is having exist attachments
    And   I Navigate and switch the window to Bid List Record
    And   I click on Search box and enter the search value
    #InsideBidContentSearch needs to provide the content for search in config file.
    And   Verify the entered value gets return or not

  @TC010_SearchAsAdvanceBase #done
  Scenario:  Verify the search functionality as advance column with content search
    Given I have logged in full permission user model AdminRights
    And I click on Bid List Menu Item
    And   I Navigate to click on Bid record who is having exist attachments
    And   I Navigate and switch the window to Bid List Record
    And   I click on Search box and enter the data as Advance Key
    And   Verify the entered value gets return or not on AdvanceView Page

  @TC011_SearchAsKeyFromBidList #done
  Scenario:  Verify the Bid List Search as Keyword query search
    Given I have logged in full permission user model AdminRights
    And   I click on Bid List Menu Item
    And   I click on Search box and enter the Key as search value
    And   verify the key gets return sucessfully or not

  # Bid permision scenario's
  @TC012_BidPermission #done
  Scenario Outline:  Verify the Bid Created Share to another User
    Given  I have logged in full permission user model AdminRights
    And    I click on Bid List Menu Item
    And    I click on BiDRecord checkbox which we want to share
    And    Verify Share button is displayed or not
    And    I have enter the sender name as <AccountName>
    And    I have click on Send button
    Then   Verify the share notification icon display or not
    Examples:
      | AccountName |
      | sptestuser |

  @TC013_CreateBidBtnNotPresent #done
  Scenario: Verify the createBid button does not present for those who is not having permission
    Given I have logged in full permission user model testUserModel
     #Given I have logged in full permission user model
     And    I click on Bid List Menu Item
     And    I verified Create Bid button does not exist

  @TC014_DeleteBtnNotPresent #done
  Scenario: Delete the Bid Creation
    Given I have logged in full permission user model testUserModel
    And   I click on Bid List Menu Item
    And   I verify delete button does not exist

  @TC014_DeleteBtnNotPresentNegativeTesting #need to run
  Scenario: Delete the Bid Creation
    Given I have logged in full permission user model testUserModel
    And   I click on Bid List Menu Item
    And   I click on Bid Created
    And   I verify delete button does not exist


  @TC015_DeleteBidCreation #done
  Scenario: Delete the Bid Creation
    Given I have logged in full permission user model AdminRights
    And   I click on Bid List Menu Item
    And   I click on Bid Created
    And   I click on Delete button for deleting the Bid Manager record
    And   I click on delete confirmation button for deleting
    Then  Verify the respective record got deleted


  @TC016_FinalSubmission #done
  Scenario Outline: Bid List make the final Submission of respective attachment
    Given I have logged in full permission user model AdminRights
    And   I click on Bid List Menu Item
    And   I click on Create New bid button
    And   I Create new bids with values <BidTitle> and <ClientName> and <BidEventType> and <BidManager> and <SalesLead> and <Sensitivitylevel> and <Notes> and <Securityclearancerequirements> and <SubmissionInstructions>
    And   I Verify the finalSubmission bid Creation successfully created with values of <BidTitle> and <ClientName> and <BidEventType> and <BidManager> and <SalesLead> and <Sensitivitylevel> and <Notes> and <Securityclearancerequirements> and <SubmissionInstructions>
    And   I Navigate to Upload the buttons
    And   I Navigate to verify document and selection drop value as <DocName> and <BidEventTypes> and <DocumentGrp> and <subGrp>
    And   I select the attachment for making final Submission
    And   I Navigate to Final Submission
    And   Verify Respective document status should get change
    Examples:
      | BidTitle    | ClientName       | BidEventType | BidManager     | SalesLead       | Sensitivitylevel  | Notes  | Securityclearancerequirements  | SubmissionInstructions  |DocName                           |BidEventTypes|DocumentGrp   |subGrp|
      | BidFinal Summission Test for Standar Security Telecom | British Telecom1 | BAFO   | Test | Matthew T | Standard Security | Notes1 | SecurityClearanceRequirements1 | SubmissionInstructions1 |Bid Plan and Tracker - CRM 103501|BAFO|Bid Planning|Bid Plan|

  @TC017_DeleteBidCreationforFinalSubmission  #issue
  Scenario: Delete the Bid Creation
    Given I have logged in full permission user model AdminRights
    And I click on Bid List Menu Item
    And   I click on Bid Created as "BidFinalSubmission"
    And   I click on Delete button for deleting the Bid Manager record
    And   I click on delete confirmation button for deleting
    Then  Verify the respective record got deleted


   #POC task as Drag and Drop functionality
  # @TC018_DragAndDropFiles
  # Scenario Outline: : Create New bids
     #Given I have logged in full permission user model AdminRights
     #And   I click on Bid List Menu Item
     #And   I click on Create New bid button
    # And   I Create new bids with values <BidTitle> and <ClientName> and <BidEventType> and <BidManager> and <SalesLead> and <Sensitivitylevel> and <Notes> and <Securityclearancerequirements> and <SubmissionInstructions>
    # And   I Verify the bid Creation successfully created with values of <BidTitle> and <ClientName> and <BidEventType> and <BidManager> and <SalesLead> and <Sensitivitylevel> and <Notes> and <Securityclearancerequirements> and <SubmissionInstructions>
    # Then  I drag the file from window component
   #  Examples:
       #| BidTitle       | ClientName       | BidEventType | BidManager | SalesLead | Sensitivitylevel  | Notes| Securityclearancerequirements  | SubmissionInstructions  | DocName                           |BidEventTypes|DocumentGrp   |subGrp|
   #    | UniqueNameTest | British Telecom1 | BAFO         | Test       | Matthew T | Standard Security | Notes1| SecurityClearanceRequirements1 | SubmissionInstructions1 | Bid Plan and Tracker - CRM 103501|BAFO|Bid Planning|Bid Plan|








