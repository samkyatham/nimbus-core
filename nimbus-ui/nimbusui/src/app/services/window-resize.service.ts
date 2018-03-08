/**
 * @license
 * Copyright 2016-2018 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
'use strict';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { BehaviorSubject } from 'rxjs/BehaviorSubject';

/**
 * \@author Sandeep.Mantha
 * \@whatItDoes 
 * 
 * \@howToUse 
 * 
 */
@Injectable()
export class WindowService {
    height$: Observable<number>;
    width$: Observable<number>;
    //create more Observables as and when needed for various properties
    hello: string = 'Hello';
    constructor() {
        let windowSize$ = new BehaviorSubject(getWindowSize());

        this.height$ = (windowSize$.pluck('height') as Observable<number>).distinctUntilChanged();
        this.width$ = (windowSize$.pluck('width') as Observable<number>).distinctUntilChanged();
        Observable.fromEvent(window, 'resize')
            .map(getWindowSize)
            .subscribe(windowSize$);
    }

}

function getWindowSize() {
    return {
        height: window.innerHeight,
        width: window.innerWidth
        //you can sense other parameters here
    };
}