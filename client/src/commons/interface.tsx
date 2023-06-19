export interface WriteInterface {
    bid?: number | string,
    title?: string,
    content?: string,
    name?: string,
    crtnDate?: string
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

export interface BoardListResponseInterface extends ResponseInterface {
    data: Array<WriteInterface>
}