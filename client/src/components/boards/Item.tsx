import { WriteInterface } from "../../commons/interface";

const Item: React.FC<{item:WriteInterface, isHeader:boolean}> = ({item, isHeader}) => {

    if (isHeader) {
        return (
            <div className="flex border-gray-300 border-b-[1px] h-10 items-center">
                <div className="w-24 text-center mx-1 font-bold">
                    {item.bid}
                </div>
                <div className="w-[512px] mx-1 text-center font-bold">
                    {item.title}
                </div>
                <div className="w-24 text-center mx-1 font-bold">
                    {item.writer}
                </div>
                <div className="w-24 text-center mx-1 font-bold">
                    {item.date}
                </div>
            </div>
        )
    } else {
        return (
            <div className="flex border-gray-300 border-b-[1px] h-8 items-center">
                <div className="w-24 text-center mx-1">
                    {item.bid}
                </div>
                <div className="w-[512px] mx-1">
                    {item.title}
                </div>
                <div className="w-24 text-center mx-1">
                    {item.writer}
                </div>
                <div className="w-24 text-center mx-1">
                    {item.date}
                </div>
            </div>
        )
    }

}

export default Item;