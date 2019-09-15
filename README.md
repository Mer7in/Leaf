Group Project
===

# Leaf

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
Leaf is an application in which people can get information about where they find fruits and vegetables of their choice depending mostly of the season and the region.

### App Evaluation
- **Category:** Lifestyle
- **Mobile:** Uses geolocation
- **Story:** Allow users to find location where they can buy fruits and vegetables. Users can compare price and quality of the products depending of the location.
- **Market:** Many people could like to use this app specially vegans and people who are about a healthy life.
- **Habit:** Anyone could have a desire to eat a fruit they never taste or would like to make a special dinner with a rare fruit or vegetable, they can just consult the application find the location and go getting it.
- **Scope:** The first version of the application will be the most simple possible.

## Product Specic

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* User can see a list of product available depending on the region and the season
* User can post and avaible product
* User can search for products


**Optional Nice-to-have Stories**

* User can link a product to a location whenever is avaible
* User rate a place's product
* User can get educational information about the product
* User can get cooking recipes that he could try with the product
* User can share a location as well as his impression about where he got the product

### 2. Screen Archetypes

* Stream
   * User can view a feed of avaible product
   * User can tap to see places where the product can be available
   * User can see educational information about a product
   * User can tap on a button to see a product's cooking recipes

* Detail
   * User can see the reviews of a place's product
   * User can post a review about a place's product 
   
* Creation
    * User can add a new product 
    * User can add a new place of avaibility for a product

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Home feed
* Search product
* Post a product

**Flow Navigation** (Screen to Screen)

* Stream Screen
   => Detail
* Search Screen
   => None
* Creation Screen
   => Home (after you finish posting the product)


## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="YOUR_WIREFRAME_IMAGE_URL" width=600>

### [BONUS] Digital Wireframes & Mockups
<img src="https://github.com/Mer7in/Leaf/blob/master/wireframe.PNG" width=600>

### [BONUS] Interactive Prototype

## Schema 
### Models
#### Product

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | productId     | String   | unique id for the product (default field) |
   | image         | File     | image that user posts |
   | description   | String   | name of product|
   | region        | String   | region of the country where there are places of avaibility of a product |
   | geolocation   | location | place where the product is available |
   | rate          | Number   | how good the fruit from the place is depending on different parameters  |
   | markettype    | String | Type of market where the product is available |
   |
### Networking
#### List of network requests by screen
   - Home Feed Screen
      - (Read/GET) Query all product by type
      - (Create/POST) Add a new product
      - (Search/POST) Search for a product
   - Create Post Screen
      - (Create/POST) Create a new post object
   - Search
      - (Read/GET) Query product 
