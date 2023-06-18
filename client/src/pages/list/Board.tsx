import { WriteInterface } from "commons/interface";
import Item from "./Item"

const Board: React.FC<{data: Array<WriteInterface>}> = ({data}) => {

    const Items = data.map(item => {
        return (
            <Item item={item} isHeader={false} key={item.bid}></Item>
        )
    })

    return (
        <div className="flex flex-col mx-auto">
            <div className="border-t-[2px] border-lime-400">
                <Item item={{ bid: "번호", title: "제목", name: "글쓴이", mdfdDate: "작성일" }} isHeader={true}></Item>
                {Items}
            </div>
            <div className="flex border-b-2 border-lime-400 justify-center">1 2 3 4 5</div>
        </div>
    )
}

export default Board;