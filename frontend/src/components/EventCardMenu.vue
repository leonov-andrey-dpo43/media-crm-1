<template>
    <div class="EventCardMenu">
        
        <div class="iventCardMenuElement">
            <button class="eventCardButton eventCardButtonEdit"></button>
            <span class="tooltiptext">Редактировать</span>
        </div>
        <div class="iventCardMenuElement">
            <button class="eventCardButton eventCardButtonComplete"></button>
            <span class="tooltiptext">Выполнено</span>
        </div>
        <div class="iventCardMenuElement">
            <button class="eventCardButton eventCardButtonForward"></button>
            <span class="tooltiptext">Перенос</span>
        </div>
        <div class="iventCardMenuElement">
            <button class="eventCardButton eventCardButtonCancelled"></button>
            <span class="tooltiptext">Отменено</span>
        </div>
        <div class="iventCardMenuElement">
            <button class="eventCardButton eventCardButtonDelete"></button>
            <span class="tooltiptext">Удалить</span>
        </div>
    </div>    
    
  </template>
  
  <script>

  
  </script>
  
  <!-- Add "scoped" attribute to limit CSS to this component only -->
  <style>
  
  .eventCardButton {
    width: 15px;
    height: 15px;
    border: none;
    background-size: cover;
    background-color: white;
  }
  
  .eventCardButtonEdit {
    background-image: url('../icons/pen.svg');
  }
  
  .eventCardButtonComplete{
    background-image: url('../icons/check.svg');
  }
  
  .eventCardButtonForward {
    background-image: url('../icons/arrow.svg');
  }
  
  .eventCardButtonCancelled {
    background-image: url('../icons/cross.svg');
  }
  
  .eventCardButtonDelete {
    background-image: url('../icons/trash.svg');
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
   
  .ItemMenuEl {
    position: relative;
    display: inline-block;  
    opacity: 30%;
  }
  
  .ItemContainer:hover .EventCardMenuElement {
    opacity: 100%;
  }
  
  .EventCardMenu{
    display: flex;
    justify-content: space-between;
    margin-top: 5px;
    padding-left: 10px;
    padding-right: 10px;
    opacity: 0%;
    height: 0px;
    
  }

  
  </style>
  