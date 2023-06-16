import { WriteInterface } from "../commons/interface";
import { Board, Header } from "../components";

const List = () => {

    const tempData: Array<WriteInterface> = [
        {
            bid: "1",
            title: '글입니다.',
            writer: '작성자',
        },
        {
            bid: "2",
            title: '글2입니다.',
            writer: '작성자2',
        },
        {
            bid: "3",
            title: '글3입니다.',
            writer: '작성자3',
        },
    ]

    return (
        <div className="flex flex-col">
            <Header></Header>
            <div className="my-24 mx-auto text-gray-600 font-bold text-4xl">게시판</div>
            <Board data={tempData}></Board>
        </div>
    )
}

export default List;