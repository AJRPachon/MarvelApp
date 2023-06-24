package es.ajrpachon.data.model.error

class KoreException(val asyncError: AsyncError) : Exception() {
    override fun toString(): String {
        return asyncError.toString()
    }
}