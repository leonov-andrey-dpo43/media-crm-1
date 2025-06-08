<template>
    <div id="clock" class="clock">
      {{ time }} <br />
      <span>{{ formattedDate }}</span>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        time: "",
        date: new Date() // Добавляем текущее время для использования в формате даты
      };
    },
    computed: {
      formattedDate() {
        const options = {
          weekday: 'long', // Полное название дня недели
          year: 'numeric',  // Полный год
          month: 'long',    // Полное название месяца
          day: 'numeric'    // Число месяца
        };
  
        const formatter = new Intl.DateTimeFormat('ru-RU', options);
        return formatter.format(this.date);
      }
    },
    methods: {
      updateClock() {
        const now = new Date();
        const hours = String(now.getHours()).padStart(2, '0');
        const minutes = String(now.getMinutes()).padStart(2, '0');
        this.time = `${hours}:${minutes}`;
  
        // Обновляем текущую дату
        this.date = now;
      }
    },
    mounted() {
      this.updateClock(); // Первоначальное обновление времени
      setInterval(this.updateClock, 1000); // Обновление каждую минуту
    }
  };
  </script>
  
  <style scoped>
  .clock {
    width: 100%;
    height: 70px; /* Увеличиваем высоту, чтобы разместить дату */
    font-family: 'Arial', sans-serif;
    font-size: 25px;
    font-weight: 100;
    color: #f0f0f0;
    display: flex;
    flex-direction: column; /* Изменяем направление на столбец */
    justify-content: center;
    align-items: center;
    /*background-color: #000;*/
  }
  </style>