class Solution {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        // assign each account id
        val idToNames = mutableMapOf<Int,String>()
        // account id -> emails
        val idToEmails = mutableMapOf<Int,MutableList<String>>()
        // map emails->account id
        val emailToAccounts = mutableMapOf<String, MutableList<Int>>()
        accounts.forEachIndexed { i,list ->
            idToNames[i] = list[0]
            for (j in 1 until list.size) {
                idToEmails.putIfAbsent(i, mutableListOf())
                idToEmails[i]!!.add(list[j])

                emailToAccounts.putIfAbsent(list[j], mutableListOf())
                emailToAccounts[list[j]]!!.add(i)
            }
        }

        // traverse and merge
        val visited = mutableSetOf<String>()
        val ret = mutableListOf<List<String>>()
        idToEmails.forEach{ (id, emails) ->
            val merged = dfs(id, idToEmails, emailToAccounts, visited)
            if (merged.isNotEmpty()) {
                ret.add(listOf(idToNames[id]!!) + merged.sorted())
            }
        }

        return ret.toList()
    }

    private fun dfs(id: Int, idToEmails: MutableMap<Int,MutableList<String>>, emailToAccounts: MutableMap<String, MutableList<Int>>, visited: MutableSet<String>): List<String> {
        val emails = mutableListOf<String>()
        idToEmails[id]?.forEach { email ->
            if (!visited.contains(email)) {
                // Add all emails associated with account
                emails.add(email)
                visited.add(email)
                // Merge connected accounts and add all emails
                emailToAccounts[email]?.forEach { accountId ->
                    emails.addAll(dfs(accountId, idToEmails, emailToAccounts, visited))
                }
            }
        }
        return emails
    }
}
