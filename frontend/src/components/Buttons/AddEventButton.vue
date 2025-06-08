<template>
    <div class="AddEventButton">
        <button @click="emitEvent" :id="dateId" class="AddButton"></button>
        <div class="wrap"><span class="tooltiptext">Добавить мероприятие</span></div>
    </div>
</template>

<script>
//import { ref } from 'vue'
export default {
    methods: {
        emitEvent() {
            this.$emit('openModal', this.dateId);
        }
    },
    props: {
        dateId: {
            type: String
        }
    },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.wrap {
    position: relative;
    display: inline-block;
}

.AddButton {
    width: 22px;
    height: 22px;
    background-image: url('../../icons/cross.svg');
    background-color: #d6d6d6;
    background-size: 20px;
    background-position: center;
    background-repeat: no-repeat;
    transform: rotate(45deg);
    border: none;
    border-radius: 100%;
    z-index: 100;
}


.tooltiptext {
    visibility: hidden;
    background-color: black;
    color: white;
    margin: 20px;
    padding: 6px;
    border-radius: 3px;
    position: absolute;
    top: 150%;
    left: 100%;
    z-index: 1;
}

.AddEventButton:hover .tooltiptext {
    visibility: visible;
}

.AddEventButton {


    position: sticky;
    top: 25px;
    display: flex;
    flex-wrap: nowrap;
    justify-content: center;
    align-items: center;
    border-radius: 100%;
    border: solid 1px #333;
    height: 26px;
    width: 26px;
    margin: 20px auto;
    margin-bottom: 10px;
    opacity: 60%;
}

.AddEventButton:hover {
    height: 34px;
    width: 34px;
    margin: 12px auto;
    margin-bottom: 10px;
    /*background-color: #fff;*/
    transition: 0.3s;
    opacity: 100%;
}

.AddEventButton:hover .AddButton {
    height: 28px;
    width: 28px;
    /*background-color: #fff;*/
    transition: 0.3s;
}
</style>