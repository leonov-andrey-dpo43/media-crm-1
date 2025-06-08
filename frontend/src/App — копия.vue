<template>
    <div class="container">
        <div id="NavBar">
            <SystemClock />
        </div>
        <div id="MainBar">
            <div id="LeftMenu">
                <div class="leftMenuItem">
                    Меню 1
                </div>
                <div class="leftMenuItem">
                    Меню 2
                </div>
                <div class="leftMenuItem">
                    Меню 3
                </div>



            </div>
            <div class="MainContainer">
                <Modal :dateId="dateId" :isOpen="isModalOpen" :regions="regions" :performers="performers"
                    @submit="handleSubmit" @cancel="closeModal" />
                <WeekChanger :weekNumber="currentWeekNumber" @week-action="handleWeekAction" />
                <div id="main">
                    <div class="dayEventsList" v-for="(day, index) in weekDays" :key="index" :id="day.formattedDate">
                        <div :class="index >= 5 ? 'dayOfWeekEnd dateId' : 'dayOfWeek dateId'">
                            {{ day.dayOfWeek }}<br />
                            {{ day.date }}
                        </div>
                        <ItemPost v-for="event in getEventsForDay(day.formattedDate)" :key="event.id"
                            :region="event.region" :text="event.text" :performer="event.performer" />
                        <AddEventButton @openModal="handleOpenmodal" :dateId="day.formattedDate" />
                    </div>
                </div>
            </div>
        </div>

    </div>

</template>

<script>
import axios from 'axios';
import ItemPost from './components/ItemPost.vue';
import AddEventButton from './components/Buttons/AddEventButton.vue';
import SystemClock from './components/SystemClock.vue'
import WeekChanger from './components/WeekChanger.vue'
import Modal from './components/modals/addEvent.vue';

export default {
    name: 'App',
    components: {
        ItemPost,
        SystemClock,
        AddEventButton,
        Modal,
        WeekChanger
    },    
    data() {
        return {
            isModalOpen: false,
            regions: ['Новосибирская область', 'Томская область', 'Республика Тыва'],
            performers: [],
            currentDate: new Date(), // Текущая дата
            events: [],
            dateId: ''
        };
    },
    computed: {
        currentWeekNumber() {
            const startOfYear = new Date(this.currentDate.getFullYear(), 0, 1);
            const days = Math.floor((this.currentDate - startOfYear) / (24 * 60 * 60 * 1000));
            const weekNumber = Math.ceil((days + ((startOfYear.getDay() + 1) % 7)) / 7);
            if (weekNumber === 53) return 1;
            return weekNumber;
        },
        weekDays() {
            const daysOfWeek = ['Понедельник', 'Вторник', 'Среда', 'Четверг', 'Пятница', 'Суббота', 'Воскресенье'];
            const weekStart = new Date(this.currentDate);
            weekStart.setDate(this.currentDate.getDate() - this.currentDate.getDay() + 1);

            return daysOfWeek.map((day, index) => {
                const date = new Date(weekStart);
                date.setDate(weekStart.getDate() + index);
                return {
                    dayOfWeek: day,
                    date: `${date.getDate()} ${this.getMonthName(date.getMonth())}`,
                    formattedDate: this.formatDate(date)
                };
            });
        }
    },
    methods: {
        handleOpenmodal(id) {
            this.dateId = id;
            this.isModalOpen = true;
        },
        closeModal() {
            this.isModalOpen = false;
        },
        handleSubmit() {
            // Логика для отправки данных на сервер
            //console.log('Event submitted:', event);
            this.closeModal();
        },
        handleWeekAction(action) {
            if (action === 'next') {
                this.nextWeek();
            } else if (action === 'previous') {
                this.previousWeek();
            }
        },
        getMonthName(month) {
            const months = ['января', 'февраля', 'марта', 'апреля', 'мая', 'июня', 'июля', 'августа', 'сентября', 'октября', 'ноября', 'декабря'];
            return months[month];
        },
        nextWeek() {
            this.currentDate = new Date(this.currentDate.getTime() + 7 * 24 * 60 * 60 * 1000)
            console.log(this.currentDate);
        },
        previousWeek() {
            this.currentDate = new Date(this.currentDate.getTime() - 7 * 24 * 60 * 60 * 1000)
        },
        formatDate(date) {
            const year = date.getFullYear();
            const month = String(date.getMonth() + 1).padStart(2, '0');
            const day = String(date.getDate()).padStart(2, '0');
            return `${year}-${month}-${day}`;
        },
        async fetchEvents() {
            try {
                const response = await axios.get('http://localhost/api/', {
                    params: {
                        startDate: this.weekDays[0].date,
                        endDate: this.weekDays[6].date
                    }
                });
                this.events = response.data;
                //console.log(this.events)
            } catch (error) {
                console.error('Ошибка при получении событий:', error);
            }
        },
        getEventsForDay(date) {
            return this.events.filter(event => event.date === date);
        }
    },

    mounted() {
        this.fetchEvents(); // Загружаем события при монтировании компонента

    }
};

</script>

<style>
.leftMenuItem {
    display: flex;
    flex-wrap: wrap;
    height: 75px;
    border-bottom: solid 1px #5c656e;
    justify-content: center;
    align-content: center;
}

.leftMenuItem:hover {
    background-color: #5c656e;
}

.dayOfWeek {
    color: white;
    background-color: #252525;
    font-weight: bold;
    padding-top: 10px;
    padding-bottom: 10px;
    border-radius: 5px;
}

.dayOfWeekEnd {
    color: white;
    background-color: rgb(255, 61, 61);
    font-weight: bold;
    padding-top: 10px;
    padding-bottom: 10px;
    border-radius: 5px;
}

#main {
    display: grid;
    grid-template-columns: repeat(7, 1fr);
    grid-column-gap: 5px;
    width: stretch;
    padding-top: 10px;
}

.dateId {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    position: sticky;
    top: 10px;
    margin-bottom: 10px;

}

.MainContainer {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    align-content: start;
    background-color: #d6d6d6;
    height: 100%;
    overflow-y: auto;
    width: calc(100vw - 75px);
    color: 111;
    padding-right: 10px;
    padding-left: 10px;
    font-family: inherit;
    font-size: 14px;
}

#MainBar {
    height: calc(100vh - 50px);
    width: 100vw;
    display: flex;
    position: fixed;
}

#LeftMenu {
    width: 75px;
    background-color: #2c3e50;
    color: aliceblue;
    height: 100%;


}

#NavBar {
    display: flex;
    background-color: black;
    height: 70px;

}

#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    width: 100vw;
    height: 100vh;
    position: absolute;
    top: 0px;
    left: 0px;
}

body::-webkit-scrollbar {
    display: none;
}

body {
    -ms-overflow-style: none;
    scrollbar-width: none;
}
</style>
