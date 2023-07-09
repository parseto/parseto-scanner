# tyrian 기본설정
```js
// https://tyrian.indigoengine.io/installation/

> sbt new PurpleKingdomGames/tyrian.g8

```

# tyrian 커스텀 설정 - package.json
```js
{
  "name": "parseto-frontend",
  "source": "assets/index.html", // 경로를 적절하게 변경해준다
  "scripts": {
    "start": "parcel assets/index.html --no-cache --dist-dir dist --log-level info",
    "build": "parcel build assets/index.html --dist-dir dist --log-level info"
  },
  "devDependencies": {
    "parcel": "^2.1.0",
    "postcss": "^8.4.21",
    "process": "^0.11.10",
    "tailwindcss": "^3.3.1"
  }
}

```
# tyrian 커스텀 설정 - main.js
```js
import {
  TyrianApp
} from '../target/scala-3.2.2/parseto-frontend-fastopt/main.js'; // 경로를 적절하게 변경해준다

TyrianApp.launch("myapp");


```