Feature: Purchase an item on Amazon

  @AddToWishList
  Scenario Outline: Add an item to the cart
    Given I am on the Amazon homepage
    When I search for "laptop"
    And I select the first item in the search results
    And I add the item to the wishlist
    And I login with valid credentials "<mobilenumber>"
    Then Then Click on continue
    Then I should give the "<password>"
    And click on Signin button
    Then again i should click on wishList
    Then the item should be visible in wishlist and click on viewList

    Examples:
    | mobilenumber | password |
    | 9061532115 | Sruthi@123 |


  @All
  Scenario: Purchase a best seller item
  Given I am on the Amazon homepage
  When I click on All option
  And click on Best sellers
  And click on Hot new releases
  Then select first item from the list
  And add the item to the cart


