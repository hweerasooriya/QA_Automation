$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cucumber/features/SignUp_Users.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 20,
  "name": "",
  "description": "New Users Creation Feature",
  "id": "",
  "keyword": "Feature",
  "tags": [
    {
      "line": 19,
      "name": "@SignUpTestsSets"
    }
  ]
});
formatter.scenarioOutline({
  "line": 24,
  "name": "Sign Up as a new user registration",
  "description": "",
  "id": ";sign-up-as-a-new-user-registration",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@SignUpUsers"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "User navigates to E Commerce application",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "User clicks on the \"Sign in\" button",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User inputs E-mail Address from the   given sheet \"\u003cSheetName\u003e\" and rownumber \u003cRowNumber\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "User click on the \"SubmitCreate\" button",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "User inputs account details from the   given sheet \"\u003cSheetName\u003e\" and rownumber \u003cRowNumber\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "User clicks on \"Register\" Button",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "User navigates to the My Account Page",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "User clicks on the SignOut Button",
  "keyword": "And "
});
formatter.examples({
  "line": 34,
  "name": "",
  "description": "",
  "id": ";sign-up-as-a-new-user-registration;",
  "rows": [
    {
      "cells": [
        "SheetName",
        "RowNumber"
      ],
      "line": 35,
      "id": ";sign-up-as-a-new-user-registration;;1"
    },
    {
      "cells": [
        "createAcct",
        "0"
      ],
      "line": 36,
      "id": ";sign-up-as-a-new-user-registration;;2"
    },
    {
      "cells": [
        "createAcct",
        "1"
      ],
      "line": 37,
      "id": ";sign-up-as-a-new-user-registration;;3"
    },
    {
      "cells": [
        "createAcct",
        "2"
      ],
      "line": 38,
      "id": ";sign-up-as-a-new-user-registration;;4"
    },
    {
      "cells": [
        "createAcct",
        "3"
      ],
      "line": 39,
      "id": ";sign-up-as-a-new-user-registration;;5"
    },
    {
      "cells": [
        "createAcct",
        "4"
      ],
      "line": 40,
      "id": ";sign-up-as-a-new-user-registration;;6"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 36,
  "name": "Sign Up as a new user registration",
  "description": "",
  "id": ";sign-up-as-a-new-user-registration;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@SignUpUsers"
    },
    {
      "line": 19,
      "name": "@SignUpTestsSets"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "User navigates to E Commerce application",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "User clicks on the \"Sign in\" button",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User inputs E-mail Address from the   given sheet \"createAcct\" and rownumber 0",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "User click on the \"SubmitCreate\" button",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "User inputs account details from the   given sheet \"createAcct\" and rownumber 0",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "User clicks on \"Register\" Button",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "User navigates to the My Account Page",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "User clicks on the SignOut Button",
  "keyword": "And "
});
formatter.match({
  "location": "SignupUsercreation.user_navigates_to_E_Commerce_application()"
});
formatter.result({
  "duration": 11162326141,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sign in",
      "offset": 20
    }
  ],
  "location": "SignupUsercreation.user_clicks_on_the_button(String)"
});
formatter.result({
  "duration": 3052697301,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "createAcct",
      "offset": 51
    },
    {
      "val": "0",
      "offset": 77
    }
  ],
  "location": "SignupUsercreation.user_inputs_E_mail_Address_from_the_given_sheet_and_rownumber(String,int)"
});
formatter.result({
  "duration": 824427285,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SubmitCreate",
      "offset": 19
    }
  ],
  "location": "SignupUsercreation.user_click_on_the_button(String)"
});
formatter.result({
  "duration": 98015546,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "createAcct",
      "offset": 52
    },
    {
      "val": "0",
      "offset": 78
    }
  ],
  "location": "SignupUsercreation.user_inputs_account_details_from_the_given_sheet_and_rownumber(String,int)"
});
formatter.result({
  "duration": 4323150984,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Register",
      "offset": 16
    }
  ],
  "location": "SignupUsercreation.user_clicks_on_Button(String)"
});
formatter.result({
  "duration": 3112250849,
  "status": "passed"
});
formatter.match({
  "location": "SignupUsercreation.user_navigates_to_the_My_Account_Page()"
});
formatter.result({
  "duration": 57676784,
  "status": "passed"
});
formatter.match({
  "location": "SignupUsercreation.user_clicks_on_the_SignOut_Button()"
});
formatter.result({
  "duration": 3035734746,
  "status": "passed"
});
formatter.scenario({
  "line": 37,
  "name": "Sign Up as a new user registration",
  "description": "",
  "id": ";sign-up-as-a-new-user-registration;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@SignUpUsers"
    },
    {
      "line": 19,
      "name": "@SignUpTestsSets"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "User navigates to E Commerce application",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "User clicks on the \"Sign in\" button",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User inputs E-mail Address from the   given sheet \"createAcct\" and rownumber 1",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "User click on the \"SubmitCreate\" button",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "User inputs account details from the   given sheet \"createAcct\" and rownumber 1",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "User clicks on \"Register\" Button",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "User navigates to the My Account Page",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "User clicks on the SignOut Button",
  "keyword": "And "
});
formatter.match({
  "location": "SignupUsercreation.user_navigates_to_E_Commerce_application()"
});
formatter.result({
  "duration": 1540204788,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sign in",
      "offset": 20
    }
  ],
  "location": "SignupUsercreation.user_clicks_on_the_button(String)"
});
formatter.result({
  "duration": 2053965353,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "createAcct",
      "offset": 51
    },
    {
      "val": "1",
      "offset": 77
    }
  ],
  "location": "SignupUsercreation.user_inputs_E_mail_Address_from_the_given_sheet_and_rownumber(String,int)"
});
formatter.result({
  "duration": 230088752,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SubmitCreate",
      "offset": 19
    }
  ],
  "location": "SignupUsercreation.user_click_on_the_button(String)"
});
formatter.result({
  "duration": 89684739,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "createAcct",
      "offset": 52
    },
    {
      "val": "1",
      "offset": 78
    }
  ],
  "location": "SignupUsercreation.user_inputs_account_details_from_the_given_sheet_and_rownumber(String,int)"
});
formatter.result({
  "duration": 4296958208,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Register",
      "offset": 16
    }
  ],
  "location": "SignupUsercreation.user_clicks_on_Button(String)"
});
formatter.result({
  "duration": 2101703082,
  "status": "passed"
});
formatter.match({
  "location": "SignupUsercreation.user_navigates_to_the_My_Account_Page()"
});
formatter.result({
  "duration": 56988429,
  "status": "passed"
});
formatter.match({
  "location": "SignupUsercreation.user_clicks_on_the_SignOut_Button()"
});
formatter.result({
  "duration": 2468636880,
  "status": "passed"
});
formatter.scenario({
  "line": 38,
  "name": "Sign Up as a new user registration",
  "description": "",
  "id": ";sign-up-as-a-new-user-registration;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@SignUpUsers"
    },
    {
      "line": 19,
      "name": "@SignUpTestsSets"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "User navigates to E Commerce application",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "User clicks on the \"Sign in\" button",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User inputs E-mail Address from the   given sheet \"createAcct\" and rownumber 2",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "User click on the \"SubmitCreate\" button",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "User inputs account details from the   given sheet \"createAcct\" and rownumber 2",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "User clicks on \"Register\" Button",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "User navigates to the My Account Page",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "User clicks on the SignOut Button",
  "keyword": "And "
});
formatter.match({
  "location": "SignupUsercreation.user_navigates_to_E_Commerce_application()"
});
formatter.result({
  "duration": 1483509338,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sign in",
      "offset": 20
    }
  ],
  "location": "SignupUsercreation.user_clicks_on_the_button(String)"
});
formatter.result({
  "duration": 1576420244,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "createAcct",
      "offset": 51
    },
    {
      "val": "2",
      "offset": 77
    }
  ],
  "location": "SignupUsercreation.user_inputs_E_mail_Address_from_the_given_sheet_and_rownumber(String,int)"
});
formatter.result({
  "duration": 246503467,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SubmitCreate",
      "offset": 19
    }
  ],
  "location": "SignupUsercreation.user_click_on_the_button(String)"
});
formatter.result({
  "duration": 87447869,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "createAcct",
      "offset": 52
    },
    {
      "val": "2",
      "offset": 78
    }
  ],
  "location": "SignupUsercreation.user_inputs_account_details_from_the_given_sheet_and_rownumber(String,int)"
});
formatter.result({
  "duration": 3993704677,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Register",
      "offset": 16
    }
  ],
  "location": "SignupUsercreation.user_clicks_on_Button(String)"
});
formatter.result({
  "duration": 2789978798,
  "status": "passed"
});
formatter.match({
  "location": "SignupUsercreation.user_navigates_to_the_My_Account_Page()"
});
formatter.result({
  "duration": 52250723,
  "status": "passed"
});
formatter.match({
  "location": "SignupUsercreation.user_clicks_on_the_SignOut_Button()"
});
formatter.result({
  "duration": 2316481332,
  "status": "passed"
});
formatter.scenario({
  "line": 39,
  "name": "Sign Up as a new user registration",
  "description": "",
  "id": ";sign-up-as-a-new-user-registration;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@SignUpUsers"
    },
    {
      "line": 19,
      "name": "@SignUpTestsSets"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "User navigates to E Commerce application",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "User clicks on the \"Sign in\" button",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User inputs E-mail Address from the   given sheet \"createAcct\" and rownumber 3",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "User click on the \"SubmitCreate\" button",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "User inputs account details from the   given sheet \"createAcct\" and rownumber 3",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "User clicks on \"Register\" Button",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "User navigates to the My Account Page",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "User clicks on the SignOut Button",
  "keyword": "And "
});
formatter.match({
  "location": "SignupUsercreation.user_navigates_to_E_Commerce_application()"
});
formatter.result({
  "duration": 1271739940,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sign in",
      "offset": 20
    }
  ],
  "location": "SignupUsercreation.user_clicks_on_the_button(String)"
});
formatter.result({
  "duration": 1907168169,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "createAcct",
      "offset": 51
    },
    {
      "val": "3",
      "offset": 77
    }
  ],
  "location": "SignupUsercreation.user_inputs_E_mail_Address_from_the_given_sheet_and_rownumber(String,int)"
});
formatter.result({
  "duration": 227636842,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SubmitCreate",
      "offset": 19
    }
  ],
  "location": "SignupUsercreation.user_click_on_the_button(String)"
});
formatter.result({
  "duration": 95730320,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "createAcct",
      "offset": 52
    },
    {
      "val": "3",
      "offset": 78
    }
  ],
  "location": "SignupUsercreation.user_inputs_account_details_from_the_given_sheet_and_rownumber(String,int)"
});
formatter.result({
  "duration": 3982941872,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Register",
      "offset": 16
    }
  ],
  "location": "SignupUsercreation.user_clicks_on_Button(String)"
});
formatter.result({
  "duration": 1612857568,
  "status": "passed"
});
formatter.match({
  "location": "SignupUsercreation.user_navigates_to_the_My_Account_Page()"
});
formatter.result({
  "duration": 53265620,
  "status": "passed"
});
formatter.match({
  "location": "SignupUsercreation.user_clicks_on_the_SignOut_Button()"
});
formatter.result({
  "duration": 2333001292,
  "status": "passed"
});
formatter.scenario({
  "line": 40,
  "name": "Sign Up as a new user registration",
  "description": "",
  "id": ";sign-up-as-a-new-user-registration;;6",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 23,
      "name": "@SignUpUsers"
    },
    {
      "line": 19,
      "name": "@SignUpTestsSets"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "User navigates to E Commerce application",
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "User clicks on the \"Sign in\" button",
  "keyword": "And "
});
formatter.step({
  "line": 27,
  "name": "User inputs E-mail Address from the   given sheet \"createAcct\" and rownumber 4",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "User click on the \"SubmitCreate\" button",
  "keyword": "And "
});
formatter.step({
  "line": 29,
  "name": "User inputs account details from the   given sheet \"createAcct\" and rownumber 4",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "User clicks on \"Register\" Button",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "User navigates to the My Account Page",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "User clicks on the SignOut Button",
  "keyword": "And "
});
formatter.match({
  "location": "SignupUsercreation.user_navigates_to_E_Commerce_application()"
});
formatter.result({
  "duration": 2425610119,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sign in",
      "offset": 20
    }
  ],
  "location": "SignupUsercreation.user_clicks_on_the_button(String)"
});
formatter.result({
  "duration": 2020705274,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "createAcct",
      "offset": 51
    },
    {
      "val": "4",
      "offset": 77
    }
  ],
  "location": "SignupUsercreation.user_inputs_E_mail_Address_from_the_given_sheet_and_rownumber(String,int)"
});
formatter.result({
  "duration": 199425081,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SubmitCreate",
      "offset": 19
    }
  ],
  "location": "SignupUsercreation.user_click_on_the_button(String)"
});
formatter.result({
  "duration": 101095509,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "createAcct",
      "offset": 52
    },
    {
      "val": "4",
      "offset": 78
    }
  ],
  "location": "SignupUsercreation.user_inputs_account_details_from_the_given_sheet_and_rownumber(String,int)"
});
formatter.result({
  "duration": 3920045534,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Register",
      "offset": 16
    }
  ],
  "location": "SignupUsercreation.user_clicks_on_Button(String)"
});
formatter.result({
  "duration": 2122734329,
  "status": "passed"
});
formatter.match({
  "location": "SignupUsercreation.user_navigates_to_the_My_Account_Page()"
});
formatter.result({
  "duration": 54871593,
  "status": "passed"
});
formatter.match({
  "location": "SignupUsercreation.user_clicks_on_the_SignOut_Button()"
});
formatter.result({
  "duration": 2629655715,
  "status": "passed"
});
});