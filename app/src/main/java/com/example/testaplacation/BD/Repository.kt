package com.example.testaplacation.BD

import com.example.testaplacation.models.Cash
import com.example.testaplacation.models.Course

class Repository {

    open class BaseCourse(
        private val dataCourse: CoursesDao
    ) {
        fun courseList(): List<Course> {
            return dataCourse.list().map {
                Course(
                    it.id.toInt(),
                    it.title,
                    it.text,
                    it.price,
                    it.rate,
                    it.startDate,
                    it.hasLike == "true",
                    it.publishDate
                )
            }
        }

        fun add(course: Course) {
            dataCourse.add(
                CourseCache(
                    course.id.toLong(),
                    course.title,
                    course.text,
                    course.price,
                    course.rate,
                    course.startDate,
                    course.hasLike.toString(),
                    course.publishDate
                )
            )
        }

        fun update(course: Course) {
            dataCourse.update(
                CourseCache(
                    course.id.toLong(),
                    course.title,
                    course.text,
                    course.price,
                    course.rate,
                    course.startDate,
                    course.hasLike.toString(),
                    course.publishDate
                )
            )
        }

        fun delete(course: Course) {
            dataCourse.delete(course.id.toLong())
        }
    }

    open class CashBase(
        private val dataCash: CashDao
    ) {
        fun courseList(): List<Cash> {
            return dataCash.list().map {
                Cash(it.id.toInt(), it.text)
            }
        }

        fun add(cash: Cash) {
            dataCash.add(CashCache(cash.id.toLong(), cash.text))
        }

        fun update(cash: Cash) {
            dataCash.update(CashCache(cash.id.toLong(), cash.text))
        }

        fun delete(cash: Cash) {
            dataCash.delete(cash.id.toLong())
        }
    }
}