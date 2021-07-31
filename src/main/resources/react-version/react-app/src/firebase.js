import firebase from "firebase";

const firebaseConfig = {
  apiKey: "AIzaSyD7Cp2hJk6pp81Xu646k3jfY3bMZ16yFHE",
  authDomain: "four-artist.firebaseapp.com",
  databaseURL: "https://four-artist.firebaseio.com",
  projectId: "four-artist",
  storageBucket: "four-artist.appspot.com",
  messagingSenderId: "290084440030",
  appId: "1:290084440030:web:98b6a2f2c1515d708fbf4f",
  measurementId: "G-T63KHF6EXC"
};

  const firebaseApp = firebase.initializeApp(firebaseConfig);
  const db = firebaseApp.firestore();
  const auth = firebase.auth();
  const provider = new firebase.auth.GoogleAuthProvider();

  export{ auth, provider };
  export default db;