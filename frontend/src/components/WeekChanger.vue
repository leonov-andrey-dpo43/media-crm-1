<template>
    <div class="week-selector">
      <button @click="handleClick('previous')">«</button>
      <span id="weekNumberLabel">{{ weekNumber }} неделя</span>
      <button @click="handleClick('next')">»</button>
    </div>
  </template>
  
  <script>
  export default {
    props: {
      weekNumber: Number
    },    
    methods: {
      handleClick(action) {
        this.$emit('week-action', action);
      }
    }
  };
  </script>
  
  <style scoped>
  .week-selector {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 50px;
    font-family: 'Arial', sans-serif;
    font-size: 24px;
  }
  #weekNumberLabel{
    background-color: rgba(255, 255, 255, 0.3);
    height: 45px;
    padding: 0px 20px;
    border-radius: 5px;
    align-content: center;
    justify-content: center;
    box-shadow: 5px 5px 15px 0px rgba(0, 0, 0, 0.3);
  }
  button {
    border: none;
    background-color: rgba(255, 255, 255, 0);
    color: white;
    border: solid 2px  #4682B4;
    padding: 5px 10px;
    margin: 0 20px;
    border-radius: 5px;
    cursor: pointer;
    font-size: 24px;
    height: 45px;
    box-shadow: 5px 5px 15px 0px rgba(0, 0, 0, 0.3);
  }
  
  button:hover {
    background-color: #0056b3;
    border: solid 2px  #0056b3;
    transition: 0.3s;
  }
  </style>