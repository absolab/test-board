export interface WriteInterface {
    bid?: string,
    title?: string,
    content?: string,
    writer?: string,
    date?: string
}

export const ResponseResultValue = {
    SUCCESS: 'SUCCESS',
    FAIL: 'FAIL',
}

export interface ResponseInterface {
    result: string,
    msg: string,
    data: Object,
}

export interface LoginResponseInterface extends ResponseInterface {
    data: {
        id: string,
        name: string,
        reg_date: string,
    }
}