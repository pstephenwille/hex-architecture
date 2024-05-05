import React, {useEffect, useState} from 'react';

interface CommentsProps {
    storyId: number
}

export const Comments = ({storyId}: CommentsProps) => {
    const [comments, setComments] = useState([]);

    const CommentsList = () => {
        return (
            <div id={`comments`}>
                {comments.map((comment: any, idx: number) => {
                    return (
                        <ul key={idx} className={'comment'}>
                            <li><span className={'label'}> By: </span> {comment.by}</li>
                            <li><span className={'label'}> Comment: </span>
                                <div dangerouslySetInnerHTML={{__html: comment.text}}/>
                            </li>
                        </ul>)
                })}
            </div>)
    }

    useEffect(() => {
        fetch(`http://localhost:8080/comments/${storyId}`)
            .then(resp => resp.json())
            .then(data => setComments(data));
    }, [])

    return (
        <div>{(comments.length)
            ? <CommentsList/>
            : ''}
        </div>)
}
