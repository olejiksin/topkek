import {
    ADD_COPY_INSTANCE,
    ADD_INSTANCE, DELETE_SERVICE,
    ERROR, LOGOUT,
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
