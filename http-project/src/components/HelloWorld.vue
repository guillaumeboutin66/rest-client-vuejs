<template>
    <div class="hello">
        <div>JSON of train is : <br />
        <p> Heure Depart : 12h50  -- numTrain : TR123 -- ville de départ : Poitiers -- Ville d'arrivée : Paris</p><br />
        {{ trains }}<br />
        </div>
        <br />
        <div>JSON of booktrain is :  <br />
        <p> Number places : 12h50  -- numTrain : TR123</p><br />
        {{ booktrains }}</div>
        <br />
        <input type="text" v-model="input.numTrain" placeholder="Num train" />
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
                ip: "",
                input: {
                    numTrain: "",
                    numberPlaces: ""
                },
                response: ""
            }
        },
        trainsLoad() {
            axios({ method: "GET", "url": "http://localhost:8080/RestProject/webresources/trains" }).then(result => {
                this.trains = result.data;
            }, error => {
                console.error(error);
            });
        },
        trainBookLoad() {
            axios({ method: "GET", "url": "http://localhost:8080/REST_COURS1/webresources/booktrains" }).then(result => {
                this.booktrains = result.data;
            }, error => {
                console.error(error);
            });
        },
        methods: {
            sendData() {
                axios({ method: "POST", "url": "https://httpbin.org/post", "data": this.input, "headers": { "content-type": "application/json", "Access-Control-Allow-Origin": "*" , "Accept": "application/json"} }).then(result => {
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