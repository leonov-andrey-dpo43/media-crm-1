<template>
  <div v-if="isOpen" class="modal-backdrop">
    <div class="modal">
      <h2>Добавить мероприятие</h2>
      <form @submit.prevent="submitForm" class="form-container">
        <div class="form-item">
          <input type="text" :value="event.dayOfWeek" id="dayOfWeek" readonly />
        </div>
        <div class="form-item">
          <select v-model="event.region" id="region" @change="updatePerformers" required>
            <option value="" disabled selected>Выберите регион</option>
            <option v-for="region in regions" :key="region" :value="region">{{ region }}</option>
          </select>
        </div>
        <div class="form-item">
          <textarea placeholder="Внесите информацию о мероприятии.." v-model="event.text" id="text" required
            spellcheck="true"></textarea>
        </div>
        <div class="form-item">
          <select v-model="event.performer" id="performer" required>
            <option value="" disabled selected>Выберите исполнителя</option>
            <option v-for="performer in localPerformers" :key="performer" :value="performer">{{ performer }}</option>
          </select>
        </div>
        <div class="form-buttons">
          <button type="submit">Сохранить</button>
          <button type="button" @click="cancel">Отмена</button>
        </div>
        <!-- Сообщения -->
        <p v-if="errorMessage" style="color: red;">{{ errorMessage }}</p>
        <p v-if="successMessage" style="color: green;">{{ successMessage }}</p>
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Modal',
  props: {
    isOpen: {
      type: Boolean,
      required: true
    },
    regions: {
      type: Array,
      required: true
    },
    performers: {
      type: Array,
      required: true
    },
    dateId: {
      type: String,
      required: true
    }
  },
  data() {
    return {
      event: {
        dayOfWeek: this.dateId, // сразу заполняем дату из пропса
        region: '',
        text: '',
        performer: ''
      },
      localPerformers: [],
      errorMessage: '',
      successMessage: ''
    };
  },
  methods: {
    async submitForm() {
      this.errorMessage = '';
      this.successMessage = '';

      try {
        await axios.post(`${import.meta.env.VITE_API_URL}/api/events`, {
          event_date: this.event.dayOfWeek,
          region: this.event.region,
          text: this.event.text,
          performer: this.event.performer
        });
        this.successMessage = 'Данные успешно отправлены!';
        this.$emit('submit');
        this.resetForm();
      } catch (error) {
        this.errorMessage = 'Произошла ошибка при отправке данных. Пожалуйста, попробуйте еще раз.';
        console.error('Ошибка:', error);
      }
    },
    cancel() {
      this.$emit('cancel');
      this.resetForm();
    },
    updatePerformers() {
      if (this.event.region === 'Новосибирская область') {
        this.localPerformers = ['Новосибирск', 'Бердск'];
      } else if (this.event.region === 'Томская область') {
        this.localPerformers = ['Томск', 'Северск'];
      } else if (this.event.region === 'Республика Тыва') {
        this.localPerformers = ['Кызыл', 'Шагонар'];
      } else {
        this.localPerformers = [];
      }
      this.event.performer = '';
    },
    resetForm() {
      this.event = {
        dayOfWeek: this.dateId,
        region: '',
        text: '',
        performer: ''
      };
      this.localPerformers = [];
    }
  },
  watch: {
    dateId(newVal) {
      this.event.dayOfWeek = newVal;
    }
  },
  created() {
    // Инициализация даты при создании
    this.event.dayOfWeek = this.dateId;
  }
};
</script>

<style scoped>
/* Оставляем как есть */
.modal-backdrop {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
}

.modal {
  background: white;
  width: 350px;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  font-family: inherit;
  font-size: 12px;
  z-index: 1001;
}

.form-container {
  display: flex;
  flex-direction: column;
  gap: 15px;
}

.form-item {
  display: flex;
  flex-direction: column;
}

#text {
  min-height: 200px;
}

#dayOfWeek,
#region,
#performer,
#text {
  font-family: inherit;
  font-size: 16px;
  padding: 5px;
  border-radius: 5px;
  border: solid 2px rgba(0, 0, 0, 0.5);
}

.form-buttons {
  display: flex;
  justify-content: center;
}
</style>