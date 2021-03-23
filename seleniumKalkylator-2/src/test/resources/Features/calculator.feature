Feature: Calculator
In order to avoid silly mistakes As a math idiot I want to be told the sum of two numbers

Background: 
Given I have entered https://www.marshu.com/articles/calculate-addition-calculator-add-two-numbers.php

Scenario Outline: Add two numbers

Given I have entered <no1> into the calculator

And I have also entered <no2> into the calculator

When I press <action>

Then the result should be <result> on the screen

Examples:
|no1|no2|result|action|
|51|70|121|add|
|11|13|24|add|
|13|8|21|add|