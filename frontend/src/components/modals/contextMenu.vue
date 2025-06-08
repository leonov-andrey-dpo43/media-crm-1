<template>
    <div>
      <div
        id="target"
        class="target"
        @contextmenu.prevent="showContextMenu"
        @click="hideContextMenu"
      >
        Нажмите правой кнопкой мыши на меня
      </div>
      <div
        v-if="isMenuVisible"
        class="context-menu"
        :style="{ left: `${menuPosition.x}px`, top: `${menuPosition.y}px` }"
      >
        <ul>
          <li @click="selectOption(1)">Пункт 1</li>
          <li @click="selectOption(2)">Пункт 2</li>
          <li @click="selectOption(3)">Пункт 3</li>
        </ul>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        isMenuVisible: false,
        menuPosition: { x: 0, y: 0 },
      };
    },
    methods: {
      showContextMenu(event) {
        this.isMenuVisible = true;
        this.menuPosition.x = event.pageX;
        this.menuPosition.y = event.pageY;
      },
      hideContextMenu() {
        this.isMenuVisible = false;
      },
      selectOption(option) {
        alert(`Вы выбрали пункт ${option}`);
        this.hideContextMenu();
      },
    },
  };
  </script>
  
  <style>
  .target {
    width: 300px;
    height: 100px;
    background-color: #f0f0f0;
    border: 1px solid #ccc;
    display: flex;
    align-items: center;
    justify-content: center;
    margin: 50px auto;
    cursor: pointer;
  }
  
  .context-menu {
    position: absolute;
    background-color: white;
    border: 1px solid #ccc;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
    z-index: 1000;
  }
  
  .context-menu ul {
    list-style: none;
    padding: 10px;
    margin: 0;
  }
  
  .context-menu li {
    padding: 8px 12px;
    cursor: pointer;
  }
  
  .context-menu li:hover {
    background-color: #f0f0f0;
  }
  </style>