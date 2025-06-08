<template>
  <div class="itemContainer" :id="eventId">
    
    
      <div class=item>
      
        
      <div class="title">{{ region }}</div>
      <div class="text">{{ text }}</div>
      <div class="sign">
        Отв. исп.:
        <br/>
        {{ performer }}
      </div>
    </div>
    <div class="ItemMenu">
      <CardButtonEdit/>
      <CardButtonInfo/>
      <CardButtonCompleted/>
      <CardButtonForward/>
      <CardButtonCancelled/>
      <CardButtonDelete @click="emitDeleteEvent"/>
    </div>    
  </div>
</template>

<script>
import CardButtonEdit from './Buttons/CardButtonEdit.vue';
import CardButtonInfo from './Buttons/CardButtonInfo.vue';
import CardButtonCompleted from './Buttons/CardButtonCompleted.vue';
import CardButtonForward from './Buttons/CardButtonForward.vue';
import CardButtonCancelled from './Buttons/CardButtonCancelled.vue';
import CardButtonDelete from './Buttons/CardButtonDelete.vue';

export default {
  components: {
    CardButtonEdit,
    CardButtonInfo,
    CardButtonCompleted,
    CardButtonForward,
    CardButtonCancelled,
    CardButtonDelete
  },
  props: {
    region: String,
    text: String,
    performer: String,
    eventId: Number,
  },
  methods: {
        emitDeleteEvent() {
            this.$emit('deleteEvent', this.eventId);
        }
    },  
};
</script>
 
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

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

.ItemMenuEl:hover .tooltiptext {
  visibility: visible;
}
.itemContainer {
  border-radius: 5px;
  box-shadow: 5px 5px 15px 0px rgba(0, 0, 0, 0.3); 
  margin-bottom: 5px;
}

.iconScale {
  height: 15px;

}
.ItemMenuEl {
  position: relative;
  display: inline-block;  
  opacity: 30%;
}

.ItemMenuEl:hover {
  opacity: 100%;
}

.ItemMenu{
  display: flex;
  justify-content: space-between;
  padding-left: 10px;
  padding-right: 10px;
  opacity: 0%;
  height: 0px;
  
}

.title {
  text-align: center;
  font-weight: bold;
}
.text {
  margin-top: 10px;
  margin-bottom: 10px;
  text-align: justify;
}

.sign {
  text-align: left;
  font-weight: bold;
  font-style: italic;
}

.item {
  color:#444;
  background-color: rgba(243, 243, 243, 0.6);
  border-radius: 5px;
  padding: 5px;
  border-left: solid 5px white;
}

.itemContainer:hover  .ItemMenu {
  opacity: 100%;
  height: 25px;
  transition: 0.3s;
  margin-bottom: 5px;
  padding-top: 10px;
  border-top: solid 1px rgba(0, 0, 0, 0.3);
}
.itemContainer:hover{
  background-color: #ffffff;
  padding-bottom: 5px;
}

.itemContainer:hover .item{
  background-color: #ffffff;
  border-bottom-right-radius: 0px;
  border-bottom-left-radius: 0px;
}

</style>
