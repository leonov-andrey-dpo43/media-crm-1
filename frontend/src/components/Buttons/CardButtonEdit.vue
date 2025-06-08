<template>
    <div class="EventCardMenuElement">
            <button @click="EditEvent" class="eventCardButton"><font-awesome-icon icon="pen-nib"/></button>
            <span class="tooltiptext">Редактировать</span>
    </div>    
</template>
  
  <script>
  //import { ref } from 'vue'

  export default {
    
    setup() {
      const msg = 'Edited'
      return { msg }
    },
    
    methods: {
    EditEvent() {
        let div = document.createElement('div');

div.style.overflowY = 'scroll';
div.style.width = '50px';
div.style.height = '50px';

// мы должны вставить элемент в документ, иначе размеры будут равны 0
document.body.append(div);
let scrollWidth = div.offsetWidth - div.clientWidth;

div.remove();

alert(scrollWidth);
      /*alert(this.msg)*/
    }
  
  }
  }
  
  </script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style scoped>
  
  .eventCardButton {
    width: 20px;
    height: 20px;
    border: none;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: white;
    opacity: 30%;  
    font-size: 20px;
    color: black;
  }

  .eventCardButton:hover {
    opacity: 100%;
  }
  
  .tooltiptext {
    visibility: hidden;
    background-color: black;
    color: white;
    padding: 6px;
    border-radius: 3px;
    position: absolute;
    top:200%;
    left: 0%;
    z-index: 1;
  }
  
  .EventCardMenuElement:hover .tooltiptext {
    visibility: visible;
  }
  
  .EventCardMenuElement {
    position: relative;
    display: inline-block;    
  }
  
  </style>
  