<template>
    <div class="hello">
        <div>JSON of train is : <br />
          <li v-for="train in trains">Heure Depart :{{ train.heureDepart }}  -- numTrain : {{ train.numTrain }} -- ville de départ : {{ train.villeArrivee }} -- Ville d'arrivée :{{ train.villeDepart }}</li></div>
        <br />
        <div>JSON of booktrain is :  <br />
          <li v-for="booktrain in booktrains">Nombre de places :{{ booktrain.numberPlaces }}  -- numTrain : {{ booktrain.bookNumber }}</li></div>
        <br />
        <input type="text" v-model="input.bookNumber" placeholder="Numero reservation" />
        <input type="text" v-model="input.numberPlaces" placeholder="Number place" />
        <button v-on:click="sendData()">Send</button>
        <br />
        <br />
        <textarea>{{ response }}</textarea>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: 'HelloWorld',
        data () {
            return {
                trains: "",
                booktrains: "",
                input: {
                    "bookNumber": "",
                    "numberPlaces": ""
                },
                response: ""
            }
        },
        mounted() {
            axios({ method: "GET", "url": "http://localhost:8080/REST_COURS1/webresources/trains","Access-Control-Allow-Origin": "*"}).then(result => {
                this.trains = result.data;
            }, error => {
                console.error(error);
            });
            axios({ method: "GET", "url": "http://localhost:8080/REST_COURS1/webresources/booktrains","Access-Control-Allow-Origin": "*"}).then(result => {
                this.booktrains = result.data;
            }, error => {
                console.error(error);
            });
        },
        methods: {
            sendData() {
                /*axios( { method: 'POST',
                  "url": 'http://localhost:8080/REST_COURS1/webresources/booktrains/createBookTrain',
                  'Content-Type': 'application/json' ,
                  "body": '{ "bookNumber": "TR123", "numberPlaces": "42" }'})
                  */
              axios.post('http://localhost:8080/REST_COURS1/webresources/booktrains/createBookTrain',
                { bookNumber: 'TR123', numberPlaces: '42' }
              ).then(result => {
                    this.response = result.data;
                }, error => {
                    console.error(error);
                });
            }
        }
    }
</script>

<style scoped>
    h1, h2 {
        font-weight: normal;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        display: inline-block;
        margin: 0 10px;
    }

    a {
        color: #42b983;
    }

    textarea {
        width: 600px;
        height: 200px;
    }
</style>
