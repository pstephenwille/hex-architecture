import React, {useEffect, useLayoutEffect, useState} from 'react';
import {Comments} from "./comments";

export interface TopStoriesProps {
    pageable: { content: any[], total: number, pageNumber: number }
    title: string
}


export const TopStories = (props: TopStoriesProps) => {
    console.log('%c...top-stories', 'color:red', props.pageable)
    const [toggleComments, setToggleComments] = useState(false);
    const [commentsForStoryID, setCommentsForStoryID] = useState(NaN);

    const Navigation = () => (<div id={`pageNavigation`}>
        <ul>
            <li> &laquo; </li>
            <li className={`label`}>Page: {props.pageable.pageNumber || '0'}</li>
            <li className={`label`}>Total: {props.pageable.total}</li>
            <li></li>
            <li> &raquo; </li>
        </ul>
    </div>)


    useLayoutEffect(() => {
        console.log('%c...top-stories', 'color:gold', props.pageable.content.length)
    }, [props.pageable.content.length])

    return (
        <div>
            <h4>{props.title} - {props.pageable.total}</h4>

            {(props.pageable.content && props.pageable.content.length) ?
                <div>
                    <Navigation/>

                    {
                        props.pageable.content.map((story: any, idx: number) => {
                            return (
                                <div key={idx} id={`story`}>
                                    <ul>
                                        <li><span className={'label'}>Type:</span> {story.type}</li>
                                        <li><span className={'label'}>Title:</span> {story.title}</li>
                                        <li><span className={'label'}>By:</span> {story.by}</li>
                                    </ul>
                                    <button onClick={() => {
                                        setCommentsForStoryID(story.id);
                                        setToggleComments(!toggleComments)
                                    }}>Click for comments</button>
                                    {((commentsForStoryID === story.id) && toggleComments)
                                        ? <Comments storyId={story.id}/>
                                        : ''
                                    }
                                </div>)
                        })
                    }

                    <Navigation/>

                </div>
                : ''

            }

        </div>
    )
}

