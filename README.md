# Guess The Word ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white)

Guess the word is a SpringBoot application where random words are showcased and the user has to guess it character by character.

Randomly, the user will be granted a hidden word in form of _ _ _ .

User gets 5 tries to guess it.

Once the tries are exhausted, you can reload the game.

## API's

Home page of the game  `GET http://localhost:8080/game/home`

Reload game when tries are over `GET http://localhost:8080/game/reload`

## License

[MIT](https://choosealicense.com/licenses/mit/)
