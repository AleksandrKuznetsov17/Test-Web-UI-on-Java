Feature:

  Background:
    Given Product page is loaded

  Scenario Outline: Add product to the cart
    When User goes to "<firstLevelTab>" "<secondLevelTab>"
    And User select "<product>"
    And User goes to cart
    Then Cart contains "<product>"

    Examples:
      | firstLevelTab | secondLevelTab          | product                                       |
      | Гитары        | Акустические бас-гитары | Электроакустический бас BATON ROUGE X11S/BSCE |
      | Гитары        | Акустические бас-гитары | Бас-гитара CORT AB850F BK W_BAG               |


