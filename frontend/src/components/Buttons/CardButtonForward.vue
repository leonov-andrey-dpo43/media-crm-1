<template>
  <div class="EventCardMenuElement">
          <button class="eventCardButton"><font-awesome-icon icon="share"/></button>
          <span class="tooltiptext">Перенос</span>
  </div>    
</template>

<script>

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
