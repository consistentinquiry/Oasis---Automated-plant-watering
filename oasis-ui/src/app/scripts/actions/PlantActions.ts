import {Action} from "../utils/ActionTypeUtils";
import {Plant} from "../utils/EntityTypes";

export const CREATE_PLANT = "CREATE_PLANT";
export const UPDATE_PLANT = "UPDATE_PLANT";
export const DELETE_PLANT = "DELETE_PLANT";

export const GET_PLANT = "GET_PLANT";
export const GET_ALL_PLANTS = "GET_ALL_PLANTS";

const PLANT_ENDPOINT = "plants"

const plantActionCreator = (plantActionType: any) => {
    return {
        type: plantActionType,
    }
}