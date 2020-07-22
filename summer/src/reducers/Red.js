import {
    ADD_COPY_INSTANCE,
    ADD_INSTANCE, DELETE_APP, DELETE_SERVICE,
    ERROR, LOGOUT, NEW_INSTANCE,
    START_SERVICE,
    STOP_INSTANCE,
    SUCCESS,
    SUCCESS_AUTH
} from "../types/types";

export const State = {
    username: localStorage.username,
    services: [],
    error: null,
    token: {
        // value:JSON.parse(localStorage.getItem('token')).value,
        // status:JSON.parse(localStorage.getItem('token')).status,
        // userId:JSON.parse(localStorage.getItem('token')).userId
        value: null,
        status: null,
        userId: null
    },
    userId: localStorage.userId
};

export function reducer(state = State, action) {
    switch (action.type) {
        case NEW_INSTANCE: {
            console.log(action.payload);
            for(let service of state.services){
                console.log(service);
                if(service.id==action.payload.id){
                    // service.instance.push(action.payload.instance);
                    console.log(service);
                    document.location.reload();
                }
            }
            return{
                    ...state,
                }
        }
        case ADD_COPY_INSTANCE: {
            return {
                ...state,
                services: [...state.services, action.payload]
            }
        }
        case  ADD_INSTANCE: {
            return {
                ...state,
                services: [...state.services, action.payload]
            }
        }
        case START_SERVICE : {
            for (let i = 0; i < state.services.length; i++) {
                if (state.services[i].instanceId === action.payload.services.instanceId) {
                    state.services[i].status = 'active';
                }
            }
            return {
                ...state,
                services: [...state.services]
            }
        }
        case STOP_INSTANCE: {
            for (let i = 0; i < state.services.length; i++) {
                if (state.services[i].instanceId === action.payload.services.instanceId) {
                    state.services[i].status = 'not active';
                }
            }
            return {
                ...state,
                services: [...state.services]
            }
        }
        case DELETE_SERVICE: {
            let arr = state.services;
            for (let i = 0; i < state.services.length; i++) {
                if (state.services[i].instanceId === action.payload.instanceId) {
                    arr.splice(i, 1);
                    state.services = arr;
                }
            }
            return {
                ...state,
                services: [...state.services]
            }
        }
        case SUCCESS_AUTH: {
            return {
                ...state,
                username: action.payload.login,
                token: action.payload.token,
                userId: action.payload.token.userId
            }
        }
        case SUCCESS: {
            return {
                ...state,
                services: Object.values(action.payload),
                token: {
                    value: JSON.parse(localStorage.getItem('token')).value,
                    status: JSON.parse(localStorage.getItem('token')).status,
                    userId: JSON.parse(localStorage.getItem('token')).userId
                }
            }
        }
        case DELETE_APP: {
            console.log(action.payload);
            let arr = state.services;
            for (let i = 0; i < state.services.length; i++) {
                if (state.services[i].id == action.payload.id) {
                    arr.splice(i, 1);
                    state.services = arr;
                    localStorage.services = arr;
                    document.location.reload();
                }
            }
            return {
                ...state
            }
        }
        case ERROR: {
            return {
                ...state,
                error: action.payload.error
            };
        }
        case LOGOUT: {
            return {}
        }
        default: {
            return state;
        }
    }
}
