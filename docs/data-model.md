# Data Model Design

## Brainstorming

```mermaid
mindmap
  root(FoodTrack9000)
    API
      Nutritional Data
      Food Images
    Features
      Search
      Favorites
      Barcode Scanning
      Meal Logging
    Data Models
      FoodItem
      User
      Favorites
      DailyLog
    Social Media
      Follow Users
      Social Feed
      Customise Profile
```

## Data Model - Initial Release
```
classDiagram
class FoodItem {
- String foodName
- String tagName
- String servingUnit
- Int servingQty
- String photoUrl
}

    class Favorite {
        - String favoriteId
        - String foodName
    }

  
```