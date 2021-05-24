import firebase from 'firebase';

var firebaseConfig = {
    apiKey: "AIzaSyA8QWmRbeUcHwbC_Wky5yLBs7COY80px38",
    authDomain: "ietilab4.firebaseapp.com",
    projectId: "ietilab4",
    storageBucket: "ietilab4.appspot.com",
    messagingSenderId: "137610257344",
    appId: "1:137610257344:web:7d08400f182176aee49e25",
    measurementId: "G-67X0RVGDRC"
  };

  var fire = firebase.initializeApp(firebaseConfig);

  export default fire;